package com.cisco.b2b.auotomation.ngc.controller;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.xml.sax.SAXException;

import com.cisco.b2b.auotomation.common.util.ReportBeanToExcelConvertor;
import com.cisco.b2b.auotomation.ngc.handler.AutomationHandler;
import com.cisco.b2b.auotomation.ngc.report.EmailReport;
import com.cisco.b2b.auotomation.ngc.report.ReportDetail;

public class AutomationController {

	/**
	 * 
	 * @param args
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws InterruptedException
	 * @throws InvalidFormatException
	 */
    public static void main(final String[] args) throws SAXException, IOException, ParserConfigurationException, InterruptedException, InvalidFormatException {

        /** Run test case execution steps **/
        final AutomationHandler autoHandler = new AutomationHandler();
        final Map<String, ReportDetail> runResultMap = autoHandler.runTestAutomation();

        /** Convert ReportBean to Excel **/
        final ReportBeanToExcelConvertor reportBeanToExcel = new ReportBeanToExcelConvertor();
        reportBeanToExcel.doConfigtask(runResultMap);
        
        /** Send execution report in mail **/
        final EmailReport emailObj = new EmailReport();
        emailObj.sendReportInMail();
    }
}
