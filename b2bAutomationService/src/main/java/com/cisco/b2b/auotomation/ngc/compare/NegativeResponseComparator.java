package com.cisco.b2b.auotomation.ngc.compare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cisco.b2b.auotomation.common.constants.CommonConstants;
import com.cisco.b2b.auotomation.ngc.constants.NGCConstants;
import com.cisco.b2b.auotomation.ngc.report.ReportDetail;

public class NegativeResponseComparator {

	public NegativeResponseComparator() {
		// Public Constructor
	}

	static Logger logger = LogManager.getLogger(NegativeResponseComparator.class);

	/**
	 * Compare negative B2B response with standard Response
	 *
	 * @param b2bNegResponseFile
	 * @param standardResponseFile
	 * @param reportDetail
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public ReportDetail compareNegResponses(final File b2bNegResponseFile, final File standardResponseFile,
			ReportDetail reportDetail) throws ParserConfigurationException, SAXException, IOException {

		List<String> attributeList = null;
		int comparisionFailureCount = 0;
		final DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();

		final DocumentBuilder builder1 = factory1.newDocumentBuilder();
		final Document b2bNegDocument = builder1.parse(b2bNegResponseFile);
		final Document standardDocument = builder1.parse(standardResponseFile);

		final Element b2bNegRoot = b2bNegDocument.getDocumentElement();
		final Element standardNegRoot = standardDocument.getDocumentElement();

		final NodeList b2bHeaderNodeList = b2bNegRoot.getElementsByTagName(NGCConstants.CONFIGURATIONHEADER);
		final NodeList standardHeaderNodeList = standardNegRoot.getElementsByTagName(NGCConstants.CONFIGURATIONHEADER);

		if (b2bHeaderNodeList.getLength() == standardHeaderNodeList.getLength()) {
			for (int nodeIterator = 0; nodeIterator < b2bHeaderNodeList.getLength(); nodeIterator++) {
				final Node b2bHeaderNode = b2bHeaderNodeList.item(nodeIterator);
				Node b2bMessageNode = b2bHeaderNode.getFirstChild();
				final Node standardHeaderNode = standardHeaderNodeList.item(nodeIterator);
				Node standardMessageNode = standardHeaderNode.getFirstChild().getNextSibling();
				reportDetail = compareFilesNodeByNode(b2bMessageNode, standardMessageNode, reportDetail);
				if (!reportDetail.getFailedSkuDetailsMap().isEmpty()) {
					comparisionFailureCount++;
				}
			}
		}
		if (comparisionFailureCount == 0) {
			reportDetail.setResult(true);
			reportDetail.setTcResult(CommonConstants.PASS);
			reportDetail.setFailureReason(CommonConstants.NA);
			logger.debug("Passed :: {}", reportDetail.getTcId());
		} else {
			reportDetail.setResult(false);
			reportDetail.setTcResult(CommonConstants.FAIL);
			reportDetail.setFailureReason(CommonConstants.TAGMISMATCH);
			for (Entry<String, List<String>> tagDetails : reportDetail.getFailedSkuDetailsMap().entrySet()) {
				attributeList = tagDetails.getValue();
				reportDetail.setB2bTagName(tagDetails.getKey());
				reportDetail.setB2bTagValue(attributeList.get(CommonConstants.ZERO));
				reportDetail.setCrossflowTagName(tagDetails.getKey());
				reportDetail.setCrossflowTagValue(attributeList.get(CommonConstants.ONE));
			}
			logger.debug("Failed :: {}", String.valueOf(reportDetail.getTcId()));
		}
		return reportDetail;
	}

	/**
	 * Parse B2B response XML file and extract nodes and their values
	 * 
	 * @param headerNode
	 * @return
	 */
	public Map<String, String> parseXMLFile(final Node headerNode) {
		final Map<String, String> tempHeaderMap = new HashMap<>();
		NodeList childList = headerNode.getChildNodes();
		if ((null != childList) && (childList.getLength() > 1)) {
			for (int childNodeCounter = 0; childNodeCounter < childList.getLength(); childNodeCounter++) {
				final Node childNode = childList.item(childNodeCounter);
				String childNodeName = childNode.getNodeName();
				String childNodeValue = childNode.getTextContent();
				if (NGCConstants.MESSAGECODE.equals(childNodeName) || NGCConstants.DESCRIPTION.equals(childNodeName)) {
					tempHeaderMap.put(childNodeName, childNodeValue);
				}
			}
		}
		return tempHeaderMap;
	}

	/**
	 * Compare generated B2B response with standard B2B response XML files tag wise
	 *
	 * @param B2BHeaderNode
	 * @param standardHeaderNode
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public ReportDetail compareFilesNodeByNode(final Node b2bHeaderNode, final Node standardHeaderNode,
			final ReportDetail reportDetail) {

		// Parse generated B2B response XML file
		final Map<String, String> tempB2BHeaderMap = parseXMLFile(b2bHeaderNode);
		// Parse standard B2B response XML file
		final Map<String, String> tempStandardMap = parseXMLFile(standardHeaderNode);		
		List<String> failedAttributeValues = new ArrayList<>();

		// Compare files tag wise
		if (tempB2BHeaderMap.size() == tempStandardMap.size()) {
			logger.info("compareFilesNodeByNode :: Entered 1st if :");
			for (final Entry<String, String> mapEntry : tempB2BHeaderMap.entrySet()) {
				final Map<String, List<String>> failedSkuDetailsMap = new HashMap<>();
				StringBuilder attributeName = new StringBuilder(mapEntry.getKey());
				StringBuilder actualAttributeValue = new StringBuilder(mapEntry.getValue());
				StringBuilder expectedAttributeValue = new StringBuilder(tempStandardMap.get(String.valueOf(attributeName)));

				if (!actualAttributeValue.equals(expectedAttributeValue)) {
					logger.info("compareFilesNodeByNode :: false");
					failedAttributeValues.add(String.valueOf(actualAttributeValue));
					failedAttributeValues.add(String.valueOf(expectedAttributeValue));
					failedSkuDetailsMap.put(String.valueOf(attributeName), failedAttributeValues);
					reportDetail.setFailedSkuDetailsMap(failedSkuDetailsMap);
					break;
				}
			}
		}
		return reportDetail;
	}
}