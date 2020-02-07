package com.cisco.b2b.util;

import java.util.ArrayList;
import java.util.List;

import com.cisco.b2b.model.Address;
import com.cisco.b2b.model.Attribute;
import com.cisco.b2b.model.B2BResponse;
import com.cisco.b2b.model.ConfigResponse;
import com.cisco.b2b.model.ConfigurationLine;
import com.cisco.b2b.model.InstallSiteLocation;
import com.cisco.b2b.model.MajorLine;
import com.cisco.b2b.model.PricingInformation;
import com.cisco.b2b.model.ProductAttributes;

public class ConfigRecommendationResponseComparator {

	public static List<CompareResult> comapreResponse(ConfigResponse configResponse, B2BResponse b2bResponse){
		List<CompareResult> compareResults = new ArrayList<CompareResult>();
		for (ConfigurationLine configurationLine : b2bResponse.getConfigurationLine()) {
			MajorLine majorLine = null;
			for (MajorLine line : configResponse.getMajorLine()) {
				if (configurationLine.getItemName().contentEquals(line.getItemName())) {
					majorLine = line;
					break;
				}
			}
			if (majorLine != null) {
			    compareResults.addAll(compareConfigMajorLineResponse(majorLine,configurationLine));
			}
			
		}
		return compareResults;
	}
	
	public static List<CompareResult> compareConfigMajorLineResponse(MajorLine majorLine, ConfigurationLine configurationLine) {
		
		List<CompareResult> compareResults = new ArrayList<CompareResult>();
		
		if (!majorLine.getItemType().equals(configurationLine.getItemType())) {
			compareResults.add(createCompareResult(majorLine.getItemName(), "ItemType", majorLine.getItemType(),
					configurationLine.getItemType(), false));
		}

		if (!majorLine.getDescription().equals(configurationLine.getDescription())) {
			compareResults.add(createCompareResult(majorLine.getItemName(), "Description", majorLine.getDescription(),
					configurationLine.getDescription(), false));

		}

		if (!majorLine.getQuantity().equals(configurationLine.getQuantity())) {
			compareResults.add(createCompareResult(majorLine.getItemName(), "Quantity", majorLine.getQuantity(),
					configurationLine.getQuantity(), false));
		}

		PricingInformation pricingInformation = configurationLine.getPricingInformation();
		if (pricingInformation != null) {
			if (!pricingInformation.getUnitListPrice().stripTrailingZeros().equals(majorLine.getUnitListPrice().stripTrailingZeros())) {
				compareResults.add(createCompareResult(majorLine.getItemName(), "UnitListPrice",
						majorLine.getUnitListPrice(), pricingInformation.getUnitListPrice(), false));
			}
			if (!pricingInformation.getExtendedListPrice().stripTrailingZeros().equals(majorLine.getExtendedListPrice().stripTrailingZeros())) {
				compareResults.add(createCompareResult(majorLine.getItemName(), "ExtendedListPrice",
						majorLine.getExtendedListPrice(), pricingInformation.getExtendedListPrice(), false));
			}

		}

		InstallSiteLocation installSiteLocation = configurationLine.getInstallSiteLocation();
		Address address = installSiteLocation.getAddress();
		if (address != null) {
			if (address.getPostalCode() != null) {
				if (!address.getPostalCode().equals(majorLine.getInstallSiteLocation().getZipcode())) {
					compareResults.add(createCompareResult(majorLine.getItemName(), "MajorLine|InstallSite|Zipcode",
							majorLine.getInstallSiteLocation().getZipcode(), installSiteLocation.getAddress().getPostalCode(),
							false));
				}
			}
			if (!installSiteLocation.getAddress().getCountryCode().equals(majorLine.getInstallSiteLocation().getCountry())) {
				compareResults.add(createCompareResult(majorLine.getItemName(), "MajorLine|InstallSite|Country",
						majorLine.getInstallSiteLocation().getCountry(), installSiteLocation.getAddress().getCountryCode(),
						false));
			}
		}

		ProductAttributes productAttribute = configurationLine.getProductAttributes();
		if (productAttribute != null) {
			if (!productAttribute.getServiceable().contentEquals(majorLine.getServiceable())) {
				compareResults.add(createCompareResult(majorLine.getItemName(), "Serviceable",
						majorLine.getServiceable(), productAttribute.getServiceable(), false));
			}
		}
		
		if(majorLine.getExtendedAttributes() != null) {
			for(Attribute attribute : majorLine.getExtendedAttributes().getAttribute()) {
				if(attribute.getName() !=null && attribute.getName().equals("LifeCyclePhase")) {
					if(!attribute.getText().equals(configurationLine.getConfigurationRecommendationAttributes().getLifeCyclePhase())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "LifeCyclePhase", attribute.getText(), configurationLine.getConfigurationRecommendationAttributes().getLifeCyclePhase(), false));
					}
				}
				if(attribute.getName() !=null && attribute.getName().equals("SERVICE_TYPE")) {
					if(!attribute.getText().equals(configurationLine.getConfigurationRecommendationAttributes().getRecommendedServiceType())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "Service_Type", attribute.getText(), configurationLine.getConfigurationRecommendationAttributes().getRecommendedServiceType(), false));
					}
				}
				if(attribute.getName() !=null && attribute.getName().equals("BusinessService")) {
					if(!attribute.getText().equals(configurationLine.getConfigurationRecommendationAttributes().getBusinessService())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "BusinessService", attribute.getText(), configurationLine.getConfigurationRecommendationAttributes().getBusinessService(), false));
					}
				}
				if(attribute.getName() !=null && attribute.getName().equals("Architecture")) {
					if(!attribute.getText().equals(configurationLine.getConfigurationRecommendationAttributes().getArchitecture())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "Architecture", attribute.getText(), configurationLine.getConfigurationRecommendationAttributes().getArchitecture(), false));
					}
				}
				if(attribute.getName() !=null && attribute.getName().equals("Deliverables")) {
					if(!attribute.getText().equals(configurationLine.getConfigurationRecommendationAttributes().getDeliverables())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "Deliverables", attribute.getText(), configurationLine.getConfigurationRecommendationAttributes().getDeliverables(), false));
					}
				}
				if(attribute.getName() !=null && attribute.getName().equals("Timelines")) {
					if(!attribute.getText().equals(configurationLine.getConfigurationRecommendationAttributes().getTimelines())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "Timelines", attribute.getText(), configurationLine.getConfigurationRecommendationAttributes().getTimelines(), false));
					}
				}
				if(attribute.getName() !=null && attribute.getName().equals("Rank")) {
					if(!attribute.getText().equals(configurationLine.getConfigurationRecommendationAttributes().getRank())){
						compareResults.add(createCompareResult(majorLine.getItemName(), "Rank", attribute.getText(), configurationLine.getConfigurationRecommendationAttributes().getRank(), false));
					}
				}
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