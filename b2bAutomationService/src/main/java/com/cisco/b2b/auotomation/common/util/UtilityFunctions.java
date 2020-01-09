package com.cisco.b2b.auotomation.common.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import com.cisco.b2b.auotomation.common.constants.CommonConstants;
import com.cisco.b2b.auotomation.ngc.compare.ResponseComaprater;
import com.cisco.b2b.auotomation.ngc.constants.NGCConstants;
import com.cisco.b2b.auotomation.ngc.report.ReportDetail;

public class UtilityFunctions {

	Logger logger = LogManager.getLogger(UtilityFunctions.class);

	/**
	 * 
	 * @param reportDetail
	 * @return
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public ReportDetail renameResponseFiles(final ReportDetail reportDetail)
			throws IOException, ParserConfigurationException, SAXException {

		String baseResponseFolderPath = NGCConstants.NGCRESPONSE_BASEFOLDERPATH;
		String e2evtResDownloadPath = NGCConstants.E2EVTRESPONSE_DOWNLOADPATH;
		String e2evtResDownloadsFolder = baseResponseFolderPath.concat(e2evtResDownloadPath);

		final ResponseComaprater responseCompObj = new ResponseComaprater();
		final File dir = new File(e2evtResDownloadsFolder);
		final FileFilter fileFilter = new WildcardFileFilter(CommonConstants.XML_ALLFILES);
		final File[] files = dir.listFiles(fileFilter);
		File configRes = null;
		File b2bRes = null;
		Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		if (files.length > 1) {
			configRes = files[0];
			b2bRes = files[1];

			return responseCompObj.compareResponsesFileByFile(b2bRes, configRes, reportDetail);
		} else {
			logger.error("No of files in folder :: {}", files.length);
		}
		return null;
	}
}
