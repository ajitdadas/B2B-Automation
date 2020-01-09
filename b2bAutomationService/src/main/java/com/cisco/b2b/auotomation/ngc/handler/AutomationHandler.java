package com.cisco.b2b.auotomation.ngc.handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import com.cisco.b2b.auotomation.common.constants.CommonConstants;
import com.cisco.b2b.auotomation.common.util.E2EVTConnectivity;
import com.cisco.b2b.auotomation.common.util.GenerateAccessToken;
import com.cisco.b2b.auotomation.ngc.compare.NegativeResponseComparator;
import com.cisco.b2b.auotomation.ngc.constants.NGCConstants;
import com.cisco.b2b.auotomation.ngc.reader.ReadTestScenariosSheet;
import com.cisco.b2b.auotomation.ngc.report.ReportDetail;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AutomationHandler {
	Logger logger = LogManager.getLogger(AutomationHandler.class);

	/**
	 * Generate String from XML file
	 *
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public String generateStringfromXML(final String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	/**
	 * Convert string to XML file
	 *
	 * @param xmlString
	 * @param path
	 * @return
	 */
	private File convertStringToXMLFile(final String xmlString, final String path) {
		Writer writer = null;
		File myFile = null;
		try {
			myFile = new File(path);
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			writer = new FileWriter(myFile);
			writer.write(xmlString);
		} catch (final IOException e) {
			logger.error("Unable to create fie :: {}", e.getMessage());
		} finally {
			try {
				if (null != writer) {
					writer.close();
				}
			} catch (final Exception ex) {
				logger.error("Unable to close writer :: {}", ex.getMessage());
			}

		}
		return myFile;
	}

	/**
	 * Send B2B request and get response
	 *
	 * @param tcNo
	 * @param entryVal
	 * @param accessToken
	 * @return
	 * @throws IOException
	 */
	public Response runAPIRequest(final String tcNo, final String filePath, final String accessToken)
			throws IOException {

		final RequestSpecification request = RestAssured.given().auth().oauth2(accessToken);
		request.header(CommonConstants.CONTENT_TYPE, CommonConstants.APPLICATION_XML);
		final int tcNoIntValue = (int) Double.parseDouble(tcNo);
		StringBuilder fileBuilder = new StringBuilder();
		final String reqFilePath = fileBuilder.append(filePath).append(NGCConstants.CONFIGRECOMMENDATION_FOLDERNAME)
				.append(tcNoIntValue).append(CommonConstants.XML_EXTENSION).toString();
		final String configRecommXMLReq = this.generateStringfromXML(reqFilePath);
		return request.body(configRecommXMLReq).post();
	}

	/**
	 * Check if response is not null
	 *
	 * @param testCaseNo
	 * @param response
	 * @param reportDetailObject
	 * @param reportDetailMapRef
	 * @return
	 */
	public Map<String, ReportDetail> checkNullResponse(final String testCaseNo, final Response response,
			final ReportDetail reportDetailObject, final Map<String, ReportDetail> reportDetailMapRef) {

		boolean isExecuted = false;

		reportDetailObject.setResult(true);
		if (null == response) {
			reportDetailObject.setResult(false);
			reportDetailObject.setTcResult(CommonConstants.FAIL);
			reportDetailObject.setFailureReason(CommonConstants.NULLRESPONSE_MSG);
			reportDetailMapRef.put(testCaseNo, reportDetailObject);
			logger.debug("Generated B2B Response is null.");
		} else {
			isExecuted = true;
			reportDetailObject.setExecuted(isExecuted);
			reportDetailMapRef.put(testCaseNo, reportDetailObject);
			logger.debug("Generated B2B Response is not null.");
		}
		return reportDetailMapRef;
	}

	/**
	 * Start test case execution
	 *
	 * @return
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws InterruptedException
	 */
	public Map<String, ReportDetail> runTestAutomation()
			throws IOException, ParserConfigurationException, SAXException, InterruptedException {

		NegativeResponseComparator negResComp = new NegativeResponseComparator();
		E2EVTConnectivity e2eConnObj = new E2EVTConnectivity();
		ReadTestScenariosSheet rTSSObj = new ReadTestScenariosSheet();
		Map<String, ReportDetail> reportDetailsMapPositve = new HashMap<>();
		Map<String, ReportDetail> reportDetailsMapNeg = new HashMap<>();
		ReportDetail reportDetailNeg = null;
		ReportDetail reportDetailPositive = null;
		final String tsFilePath = NGCConstants.TS_FILEPATH;
		final String ResFileBasePath = NGCConstants.RESP_FILEBASEPATH;
		RestAssured.baseURI = NGCConstants.BASEURI;

		/**
		 * Step 1 Call file to read test scenarios
		 **/
		final Map<String, Map<String, List<String>>> fileMap = rTSSObj.readTestScenariosSheet(new File(tsFilePath));

		/**
		 * Step 2 Generate token
		 **/
		final String accessToken = GenerateAccessToken.getAccessToken();
		logger.info("Access Token :: {}", accessToken);

		final Map<String, List<String>> positiveTcMap = fileMap.get(CommonConstants.POSITIVE);
		final Map<String, List<String>> negativeTcMap = fileMap.get(CommonConstants.NEGATIVE);

		/** Execute negative test scenarios **/
		if (!negativeTcMap.isEmpty()) {
			logger.debug("Executing Negative testcases");
			for (final Map.Entry<String, List<String>> entry : negativeTcMap.entrySet()) {
				reportDetailNeg = new ReportDetail();
				final List<String> tcDetailsList = entry.getValue();
				final String tcName = tcDetailsList.get(CommonConstants.ZERO);
				final String filePath = tcDetailsList.get(CommonConstants.ONE);
				final String tcNo = entry.getKey();
				reportDetailNeg.setTcName(tcName);
				final int tcNoIntValue = (int) Double.parseDouble(tcNo);
				final String resFilePath = tcNoIntValue + CommonConstants.RESPONSE_XML;
				final String negResFilePath = ResFileBasePath.concat(resFilePath);
				final String standardResPath = filePath.concat(NGCConstants.CONFIGRECOMMENDATION_RESPONSEFOLDER)
						.concat(String.valueOf(tcNoIntValue)).concat(CommonConstants.XML_EXTENSION);
				final Response response = runAPIRequest(tcNo, filePath, accessToken);
				final String bodId = response.getHeader(CommonConstants.MASHERY_ID);
				reportDetailNeg.setBodId(bodId);
				reportDetailsMapNeg = checkNullResponse(tcNo, response, reportDetailNeg, reportDetailsMapNeg);
				if (reportDetailsMapNeg.get(tcNo).isResult()) {
					final String negResBody = response.getBody().asString();
					final File negResFile = convertStringToXMLFile(negResBody, negResFilePath);
					final File standardResFile = new File(standardResPath);
					reportDetailNeg = negResComp.compareNegResponses(negResFile, standardResFile, reportDetailNeg);
					reportDetailsMapNeg.put(tcNo, reportDetailNeg);
				}
			}
			logger.info("Negative tescases got executed.");
		}

		/** Execute positive test scenarios **/
		if (!positiveTcMap.isEmpty()) {

			logger.debug("Executing positive testcases.");
			for (final Map.Entry<String, List<String>> entry : positiveTcMap.entrySet()) {
				reportDetailPositive = new ReportDetail();
				final List<String> tcDetailsList = entry.getValue();
				final String tcName = tcDetailsList.get(CommonConstants.ZERO);
				final String filePath = tcDetailsList.get(CommonConstants.ONE);
				reportDetailPositive.setTcName(tcName);
				final String tcNo = entry.getKey();
				final Response response = runAPIRequest(tcNo, filePath, accessToken);
				final String bodId = response.getHeader(CommonConstants.MASHERY_ID);
				reportDetailsMapPositve = checkNullResponse(tcNo, response, reportDetailPositive,
						reportDetailsMapPositve);
				if (reportDetailsMapPositve.get(tcNo).isResult()) {
					reportDetailPositive.setBodId(bodId);
					reportDetailsMapPositve.put(tcNo, reportDetailPositive);
				}
			}
			reportDetailsMapPositve = e2eConnObj.e2evtLogin(reportDetailsMapPositve);
			logger.info("Positive testcases got executed.");
		}
		reportDetailsMapPositve.putAll(reportDetailsMapNeg);
		return reportDetailsMapPositve;
	}

}
