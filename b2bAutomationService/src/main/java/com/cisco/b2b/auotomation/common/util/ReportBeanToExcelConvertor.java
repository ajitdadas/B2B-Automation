package com.cisco.b2b.auotomation.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import com.cisco.b2b.auotomation.common.constants.CommonConstants;
import com.cisco.b2b.auotomation.ngc.report.ReportDetail;

import net.sf.jxls.transformer.XLSTransformer;

public class ReportBeanToExcelConvertor {
	
	Logger logger = LogManager.getLogger(ReportBeanToExcelConvertor.class);

    public void doConfigtask(final Map<String, ReportDetail> runResultMap) throws InvalidFormatException, IOException {
    	
        String reportTemplateFile = CommonConstants.REPORT_TEMPLATE;        
        final File reportFile = new File(reportTemplateFile);
        final InputStream is = new FileInputStream(reportFile);
        final SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConstants.SDF_DDMMYYYY);
        final String currentDate = dateFormat.format(new Date());
        int passedCount = 0;
        int failedCount = 0;
        final List<ReportDetail> reportDetails = new ArrayList<>();
        for (final Map.Entry<String, ReportDetail> entry : runResultMap.entrySet()) {
            final ReportDetail reportDetailObj = entry.getValue();
            reportDetails.add(entry.getValue());
            if (reportDetailObj.isResult()) {
                passedCount++;                
            } else {
                failedCount++;        
            }
        }
        final Map<String, Object> reportbeans = new HashMap<>();
        reportbeans.put(CommonConstants.RD, reportDetails);
        reportbeans.put(CommonConstants.REPORT_TCPASSED, passedCount);
        reportbeans.put(CommonConstants.REPORT_TCFAILED, failedCount);
        reportbeans.put(CommonConstants.REPORT_DATE, currentDate);
        reportbeans.put(CommonConstants.REPORT_TCEXECUTED, passedCount + failedCount);
        reportbeans.put(CommonConstants.REPORT_TRACKNAME, CommonConstants.TRACK_NAME);
        reportbeans.put(CommonConstants.REPORT_SERVICENAME, CommonConstants.EXECUTED_SERVICE_NAME);
        
        //Transform template into report
        final XLSTransformer transformer = new XLSTransformer();
        final Workbook workBook = transformer.transformXLS(is, reportbeans);
        workBook.write(new FileOutputStream(new File(CommonConstants.REPORT_FILEPATH)));
        logger.info("Report Generated!");
    }

}
