/*
 * package com.cisco.b2b.auotomation.ngc.compare;
 * 
 * import java.io.BufferedReader; import java.io.File; import
 * java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.io.IOException; import java.io.InputStream; import
 * java.io.InputStreamReader; import java.nio.charset.StandardCharsets; import
 * java.nio.file.Files; import java.util.ArrayList; import java.util.HashMap;
 * import java.util.List; import java.util.Map; import java.util.Map.Entry;
 * import java.util.Properties; import java.util.Set;
 * 
 * import javax.xml.parsers.DocumentBuilder; import
 * javax.xml.parsers.DocumentBuilderFactory; import
 * javax.xml.parsers.ParserConfigurationException;
 * 
 * import org.apache.commons.io.FileUtils; import
 * org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
 * import org.json.JSONException; import org.json.JSONObject; import
 * org.json.XML; import org.w3c.dom.Document; import org.w3c.dom.Element; import
 * org.w3c.dom.Node; import org.w3c.dom.NodeList; import
 * org.xml.sax.SAXException;
 * 
 * import com.cisco.b2b.auotomation.common.constants.CommonConstants; import
 * com.cisco.b2b.auotomation.ngc.constants.NGCConstants; import
 * com.cisco.b2b.auotomation.ngc.report.ReportDetail;
 * 
 * public class ResponseComaprater {
 * 
 * Logger logger = LogManager.getLogger(ResponseComaprater.class);
 * 
 *//**
	 * 
	 * @param b2bResponseFile
	 * @param configResponseFile
	 * @param reportDetail
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
/*
 * public ReportDetail compareResponsesFileByFile(final File b2bResponseFile,
 * final File configResponseFileJSON, ReportDetail reportDetail) throws
 * ParserConfigurationException, SAXException, IOException { int failed = 0;
 * File configResponseFileXML = new File(
 * "C:\\Users\\avajpaye\\Desktop\\B2BAutomationProject_13-05-19\\src\\main\\resources\\Responses\\E2EVTResponse_Downloads\\payloadXML.xml"
 * ); StringBuilder failedB2BTagNameList = new StringBuilder(); StringBuilder
 * failedB2BTagValueList = new StringBuilder(); StringBuilder
 * failedConfigTagNameList = new StringBuilder(); StringBuilder
 * failedConfigTagValueList = new StringBuilder(); final DocumentBuilderFactory
 * factory = DocumentBuilderFactory.newInstance(); final DocumentBuilder builder
 * = factory.newDocumentBuilder(); final Document b2bDocument =
 * builder.parse(b2bResponseFile); this.convertJsonToXML(configResponseFileJSON,
 * configResponseFileXML);
 * 
 * final Document configDocument = builder.parse(configResponseFileXML);
 * 
 * final Element b2broot = b2bDocument.getDocumentElement(); final Element
 * configroot = configDocument.getDocumentElement();
 * 
 * final NodeList configLineNodeList =
 * b2broot.getElementsByTagName(NGCConstants.CONFIGURATIONlINE); final NodeList
 * majorLineNodeList =
 * configroot.getElementsByTagName(NGCConstants.CS_MAJORLINE); if
 * (configLineNodeList.getLength() == majorLineNodeList.getLength()) { for (int
 * configNodeItr = 0; configNodeItr < configLineNodeList.getLength();
 * configNodeItr++) { final Node configLineNode =
 * configLineNodeList.item(configNodeItr); final Node majorLineNode =
 * majorLineNodeList.item(configNodeItr); reportDetail =
 * this.compareB2BAndCrossFlowResponse(configLineNode, majorLineNode,
 * reportDetail); if (!reportDetail.getFailedSkuDetailsMap().isEmpty()) {
 * failed++; } } } if (failed == 0) { reportDetail.setResult(true);
 * reportDetail.setTcResult(CommonConstants.PASS);
 * reportDetail.setFailureReason(CommonConstants.NA);
 * logger.debug("Passed :: {}", String.valueOf(reportDetail.getTcId())); } else
 * { reportDetail.setResult(false);
 * reportDetail.setTcResult(CommonConstants.FAIL);
 * reportDetail.setFailureReason(CommonConstants.TAGMISMATCH); for
 * (Entry<String, List<String>> tagDetails :
 * reportDetail.getFailedSkuDetailsMap().entrySet()) { List<String>
 * attributeList = tagDetails.getValue();
 * failedB2BTagNameList.append(attributeList.get(CommonConstants.ZERO).concat(
 * CommonConstants.COMMA));
 * failedB2BTagValueList.append(attributeList.get(CommonConstants.ONE).concat(
 * CommonConstants.COMMA));
 * failedConfigTagNameList.append(attributeList.get(CommonConstants.TWO).concat(
 * CommonConstants.COMMA));
 * failedConfigTagValueList.append(attributeList.get(CommonConstants.THREE).
 * concat(CommonConstants.COMMA)); } String failedB2BTagName =
 * String.valueOf(failedB2BTagNameList); String failedB2BTagValue =
 * String.valueOf(failedB2BTagValueList); String failedConfigTagName =
 * String.valueOf(failedConfigTagNameList); String failedConfigTagValue =
 * String.valueOf(failedConfigTagValueList);
 * reportDetail.setB2bTagName(failedB2BTagName.replace(failedB2BTagName.charAt(
 * failedB2BTagName.length() - 1), CommonConstants.SPACE));
 * reportDetail.setB2bTagValue(failedB2BTagValue
 * .replace(failedB2BTagValue.charAt(failedB2BTagValue.length() - 1),
 * CommonConstants.SPACE)); reportDetail.setCrossflowTagName(failedConfigTagName
 * .replace(failedConfigTagName.charAt(failedConfigTagName.length() - 1),
 * CommonConstants.SPACE));
 * reportDetail.setCrossflowTagValue(failedConfigTagValue
 * .replace(failedConfigTagValue.charAt(failedConfigTagValue.length() - 1),
 * CommonConstants.SPACE)); logger.debug("Failed :: {}",
 * String.valueOf(reportDetail.getTcId())); }
 * 
 * return reportDetail; }
 * 
 *//**
	 * 
	 * @param b2bNode
	 * @param configNode
	 * @param reportDetail
	 * @return
	 * @throws IOException
	 *//*
		 * public ReportDetail compareB2BAndCrossFlowResponse(final Node b2bNode, final
		 * Node configNode, final ReportDetail reportDetail) throws IOException { final
		 * Properties properties = new Properties(); final Map<String, String>
		 * tempB2BMap = new HashMap<>(); final NodeList tempB2BList =
		 * b2bNode.getChildNodes(); final Map<String, String> tempConfigMap = new
		 * HashMap<>(); final NodeList tempConfigList = configNode.getChildNodes();
		 * 
		 * 
		 * Iterate B2B response and create map of B2B Nodes and their values
		 * 
		 * for (int m = 0; m < tempB2BList.getLength(); m++) { final Node n1 =
		 * tempB2BList.item(m);
		 * 
		 * if (n1.getNodeType() == Node.ELEMENT_NODE) { final NodeList childList =
		 * n1.getChildNodes(); if ((null != childList) && (childList.getLength() > 1)) {
		 * for (int n = 0; n < childList.getLength(); n++) { final Node n2 =
		 * childList.item(n); if (n2.getNodeType() == Node.ELEMENT_NODE) {
		 * tempB2BMap.put(n2.getNodeName(), n2.getTextContent()); } } } else {
		 * tempB2BMap.put(n1.getNodeName(), n1.getTextContent()); } } }
		 * 
		 * 
		 * TODO Avoid nested for loop everywhere Iterate crossflow response and create
		 * map of its nodes and their values
		 * 
		 * for (int m = 0; m < tempConfigList.getLength(); m++) { final Node n1 =
		 * tempConfigList.item(m); if (n1.getNodeType() == Node.ELEMENT_NODE) { final
		 * NodeList childList = n1.getChildNodes(); if ((null != childList) &&
		 * (childList.getLength() > 1)) { for (int n = 0; n < childList.getLength();
		 * n++) { final Node n2 = childList.item(n); if (n2.hasAttributes()) { final
		 * Element eElement = (Element) n2; final String attrName =
		 * eElement.getAttribute(NGCConstants.NAME); tempConfigMap.put(attrName,
		 * eElement.getTextContent()); } else if (n2.getNodeType() == Node.ELEMENT_NODE)
		 * { tempConfigMap.put(n2.getNodeName(), n2.getTextContent()); } } } else {
		 * tempConfigMap.put(n1.getNodeName(), n1.getTextContent()); } } }
		 * 
		 * 
		 * Compare B2B and CrossFlow Response tags and their values
		 * 
		 * properties.load(new FileInputStream(NGCConstants.PROPERTIES_FILEPATH)); final
		 * Set<Entry<Object, Object>> entrySet = properties.entrySet();
		 * 
		 * for (final Entry<Object, Object> entry : entrySet) { final String entryVal =
		 * entry.getKey().toString(); final String entryResp =
		 * entry.getValue().toString();
		 * 
		 * for (final Map.Entry<String, String> mapEntry : tempB2BMap.entrySet()) {
		 * final Map<String, List<String>> failedSkuDetailsMap = new HashMap<>(); final
		 * List<String> tagAndValueList = new ArrayList<>();
		 * 
		 * if (entryVal.equals(mapEntry.getKey())) { String reqConfigValue =
		 * tempConfigMap.get(entryResp); String reqB2BValue = tempB2BMap.get(entryVal);
		 * try { if (reqConfigValue.contains(CommonConstants.DOT)) { final double
		 * configVal = Double.parseDouble(reqConfigValue); reqConfigValue =
		 * String.valueOf(String.format("%.2f", configVal)); } if
		 * (reqB2BValue.contains(CommonConstants.DOT)) { final double b2bVal =
		 * Double.parseDouble(reqB2BValue); reqB2BValue =
		 * String.valueOf(String.format("%.2f", b2bVal)); } } catch (final Exception e)
		 * { logger.error(
		 * "Exception occurred while converting double value in compareB2BAndCrossFlowResponse :: {}"
		 * , e.getMessage()); }
		 * 
		 * if (!reqConfigValue.equals(reqB2BValue)) { tagAndValueList.add(entryVal);
		 * tagAndValueList.add(reqB2BValue); tagAndValueList.add(entryResp);
		 * tagAndValueList.add(reqConfigValue);
		 * failedSkuDetailsMap.put(tempB2BMap.get(NGCConstants.ITEM_NAME),
		 * tagAndValueList); reportDetail.setFailedSkuDetailsMap(failedSkuDetailsMap); }
		 * } } } return reportDetail; }
		 * 
		 * private File convertJsonToXML(File jsonFile, File configResponseFileXML) {
		 * String xmlResp; try (InputStream is = new FileInputStream(jsonFile);
		 * BufferedReader buf = new BufferedReader(new InputStreamReader(is))) { String
		 * line = buf.readLine(); StringBuilder sb = new StringBuilder(); while (line !=
		 * null) { sb.append(line).append("\n"); line = buf.readLine(); } String
		 * fileAsString = sb.toString(); xmlResp = XML.toString(new
		 * JSONObject(fileAsString)); StringBuilder sbXml = new StringBuilder(xmlResp);
		 * sbXml = sbXml.append("</" + "ConfigRecommendationResponse" + ">"); sbXml =
		 * sbXml.insert(0, "<" + "ConfigRecommendationResponse" + ">"); String xml = new
		 * String(sbXml); FileUtils.writeStringToFile(configResponseFileXML, xml,
		 * StandardCharsets.UTF_8); } catch (FileNotFoundException e) {
		 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); } catch
		 * (JSONException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * return configResponseFileXML; } }
		 */