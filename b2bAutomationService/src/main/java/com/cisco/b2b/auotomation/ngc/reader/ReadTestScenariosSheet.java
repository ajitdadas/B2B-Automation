package com.cisco.b2b.auotomation.ngc.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

import com.cisco.b2b.auotomation.common.constants.CommonConstants;
public class ReadTestScenariosSheet {

	Logger logger=LogManager.getLogger(ReadTestScenariosSheet.class);
	/**
	 * Read TestScenarios Excel Sheet and create separate maps for positive and negative scenarios
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
    public Map<String, Map<String, List<String>>> readTestScenariosSheet(final File filePath) throws IOException {
        final FileInputStream fis = new FileInputStream(filePath);
        final XSSFWorkbook excelWBook = new XSSFWorkbook(fis);
        final XSSFSheet excelWSheet = excelWBook.getSheetAt(CommonConstants.ZERO);
        fis.close();
        final int rowCount = excelWSheet.getLastRowNum() - excelWSheet.getFirstRowNum();

        final HashMap<String, List<String>> positiveTcMap = new HashMap<>();
        final HashMap<String, List<String>> negativeTcMap = new HashMap<>();
        final HashMap<String, Map<String, List<String>>> fileMap = new HashMap<>();

        for (int rowCounter = 1; rowCounter <= rowCount; rowCounter++) {
            final Row currentRow = excelWSheet.getRow(rowCounter);
            final String tcNo = currentRow.getCell(CommonConstants.ZERO).toString();
            final String runTCValue = currentRow.getCell(CommonConstants.ONE).toString();
            final String tcType = currentRow.getCell(CommonConstants.TWO).toString();
            final String tcName = currentRow.getCell(CommonConstants.THREE).toString();
            final String tcFilePath = currentRow.getCell(CommonConstants.FIVE).toString();

            /**
             * create map only if TC needs to be executed
             */
            if (CommonConstants.YES.equalsIgnoreCase(runTCValue)) {
                if (CommonConstants.NEGATIVE.equalsIgnoreCase(tcType)) {
                    negativeTcMap.put(tcNo, storeTCDetails(tcName, tcFilePath));
                } else {
                    positiveTcMap.put(tcNo, storeTCDetails(tcName, tcFilePath));
                }
            }
        }
        fileMap.put(CommonConstants.POSITIVE, positiveTcMap);
        fileMap.put(CommonConstants.NEGATIVE, negativeTcMap);
        logger.info("Positive and Negative testcase maps got created.");
        return fileMap;
    }

    public List<String> storeTCDetails(final String name, final String filePath) {
        final List<String> tcDetailsList = new ArrayList<>();
        tcDetailsList.add(name);
        tcDetailsList.add(filePath);
        return tcDetailsList;
    }

}