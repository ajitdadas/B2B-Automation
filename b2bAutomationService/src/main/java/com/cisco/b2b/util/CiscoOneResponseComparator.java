package com.cisco.b2b.util;

import java.util.ArrayList;
import java.util.List;

import com.cisco.b2b.model.B2BResponse;
import com.cisco.b2b.model.ConfigResponse;
import com.cisco.b2b.model.ConfigurationLine;
import com.cisco.b2b.model.MajorLine;

public class CiscoOneResponseComparator {
	
	public static List<CompareResult> comapreResponse(ConfigResponse configResponse, B2BResponse b2bResponse){
		List<CompareResult> compareResults = new ArrayList<CompareResult>();
		List<MajorLine> majorLines = configResponse.getMajorLine() != null && !configResponse.getMajorLine().isEmpty() ? configResponse.getMajorLine()  : new ArrayList<MajorLine>();
		List<ConfigurationLine> parentLines = new ArrayList<>(); 
		for(ConfigurationLine configurationLine :  b2bResponse.getConfigurationLine()) {
			if(configurationLine.getParentID().equals("0")) {
				parentLines.add(configurationLine);
			}
		}
		for(MajorLine majorLine : majorLines) {
			ConfigurationLine configurationLine = null;
			for(ConfigurationLine cLine : parentLines) {
				if(majorLine.getItemName().equals(cLine.getItemName())) {
					configurationLine = cLine;
					break;
				}
			}
			compareResults.addAll(compareConfigMajorLineResponse(majorLine, configurationLine));			
		}
		return compareResults;
	}
	
	public static List<CompareResult> compareConfigMajorLineResponse(MajorLine majorLine,
			ConfigurationLine configurationLine) {
		List<CompareResult> compareResults = new ArrayList<CompareResult>();
		
		if(majorLine.getBundleFlag() != null && configurationLine.getProductAttributes().getBundleFlag() !=null) {
			if(!majorLine.getBundleFlag().equals(configurationLine.getProductAttributes().getBundleFlag())){
				compareResults.add(createCompareResult(majorLine.getItemName(), "Bundle Flag", majorLine.getBundleFlag(), configurationLine.getProductAttributes().getBundleFlag(), false));
			}
		}
		if(majorLine.getBundleFlag() != null && configurationLine.getProductAttributes().getBundleFlag() == null) {
			if(!majorLine.getBundleFlag().equals(configurationLine.getProductAttributes().getBundleFlag())){
				compareResults.add(createCompareResult(majorLine.getItemName(), "Bundle Flag", majorLine.getBundleFlag(), configurationLine.getProductAttributes().getBundleFlag(), false));
			}
		}
		if(majorLine.getBundleFlag() == null && configurationLine.getProductAttributes().getBundleFlag() != null) {
			if(!majorLine.getBundleFlag().equals(configurationLine.getProductAttributes().getBundleFlag())){
				compareResults.add(createCompareResult(majorLine.getItemName(), "Bundle Flag", majorLine.getBundleFlag(), configurationLine.getProductAttributes().getBundleFlag(), false));
			}
		}
		return compareResults;
	}

	private static CompareResult createCompareResult(String itemName, String propertyName, Object value1, Object value2,
			boolean result) {
		CompareResult compareResult = new CompareResult();
		compareResult.setItemName(itemName);
		compareResult.setPropertyName(propertyName);
		compareResult.setConfigValue(value1);
		compareResult.setB2bValue(value2);
		compareResult.setResult(false);
		return compareResult;
	}
}
