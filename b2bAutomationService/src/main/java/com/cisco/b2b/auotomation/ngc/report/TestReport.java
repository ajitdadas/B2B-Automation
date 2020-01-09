package com.cisco.b2b.auotomation.ngc.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.cisco.b2b.auotomation.common.constants.CommonConstants;
import com.cisco.b2b.auotomation.ngc.constants.NGCConstants;

public class TestReport {

    private int passedCount = 0;
    private int failedCount = 0;

    /*
     * Create Execution Report
     * @Parameters(ResultMap)
     */
    public void createTestReport(final Map<String, ReportDetail> runResultMap) throws EncryptedDocumentException, IOException {

        for (final Map.Entry<String, ReportDetail> entry : runResultMap.entrySet()) {
            final ReportDetail reportDetailObj = entry.getValue();
            final Date currentDate = new Date();
            final SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConstants.SDF_DDMMYYYY);
            if (reportDetailObj.isResult()) {
                this.passedCount++;
            } else {
                this.failedCount++;
            }

            final File reportFile = new File(CommonConstants.REPORT_FILEPATH);
            try (FileOutputStream fileOut = new FileOutputStream(reportFile)) {
                final HSSFWorkbook wb = new HSSFWorkbook();
                final HSSFSheet sheet = wb.createSheet(CommonConstants.TEST_REPORT);
                final HSSFRow rowhead = sheet.createRow(0);
                final HSSFRow lastRow = sheet.createRow(1);
                final HSSFRow frRowhead = sheet.createRow(5);
                final HSSFRow frRow = sheet.createRow(6);
                final CellStyle style = null;

                /*
                 * Set Text Format
                 */
                final HSSFFont defaultFont = wb.createFont();
                // style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                defaultFont.setFontHeightInPoints((short) 10);
                defaultFont.setFontName(CommonConstants.ARIAL);
                defaultFont.setColor(IndexedColors.BLACK.getIndex());
                defaultFont.setItalic(false);

                final HSSFFont font = wb.createFont();
                font.setFontHeightInPoints((short) 10);
                font.setFontName(CommonConstants.ARIAL);
                font.setColor(IndexedColors.WHITE.getIndex());
                font.setItalic(false);

                /*
                 * Create Header Row
                 */
                rowhead.createCell(0).setCellValue(CommonConstants.DATE);
                rowhead.createCell(1).setCellValue(CommonConstants.SERVICENAME);
                rowhead.createCell(2).setCellValue(CommonConstants.TESTCASE_EXECUTED);
                rowhead.createCell(3).setCellValue(CommonConstants.TESTCASE_PASSED);
                rowhead.createCell(4).setCellValue(CommonConstants.TESTCASE_FAILED);
                for (int j = 0; j <= 4; j++) {
                    rowhead.getCell(j).setCellStyle(style);
                }

                /*
                 * Create Report Data Rows
                 */
                lastRow.createCell(0).setCellValue(dateFormat.format(currentDate));
                lastRow.createCell(1).setCellValue(NGCConstants.CONFIGRECOMMENDATION);
                lastRow.createCell(2).setCellValue(this.passedCount + this.failedCount);
                lastRow.createCell(3).setCellValue(this.passedCount);
                lastRow.createCell(4).setCellValue(this.failedCount);

                frRowhead.createCell(0).setCellValue(CommonConstants.FAILED_TCNAME);
                frRowhead.createCell(1).setCellValue(CommonConstants.FAILURE_REASON);
                frRowhead.createCell(2).setCellValue(CommonConstants.B2B_TAGNAME);
                frRowhead.createCell(3).setCellValue(CommonConstants.B2B_TAGVALUE);
                frRowhead.createCell(4).setCellValue(CommonConstants.CROSSFLOW_TAGNAME);
                frRowhead.createCell(5).setCellValue(CommonConstants.CROSSFLOW_TAGVALUE);

                /*
                 * Create Report for Failed TestCases
                 */
                for (final Entry<String, ReportDetail> RCentry : runResultMap.entrySet()) {

                    final ReportDetail reportDetail = RCentry.getValue();
                    frRow.createCell(0).setCellValue(reportDetail.getTcName());
                    frRow.createCell(1).setCellValue(reportDetail.getFailureReason());
                    frRow.createCell(2).setCellValue(reportDetail.getB2bTagName().toString());
                    frRow.createCell(3).setCellValue(reportDetail.getB2bTagValue().toString());
                    frRow.createCell(4).setCellValue(reportDetail.getCrossflowTagName().toString());
                    frRow.createCell(4).setCellValue(reportDetail.getCrossflowTagValue().toString());
                }

                wb.write(fileOut);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }
}
