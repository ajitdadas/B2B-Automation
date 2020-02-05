package com.cisco.b2b.util;

import java.util.ArrayList;
import java.util.List;

import com.cisco.b2b.model.Address;
import com.cisco.b2b.model.ConfigurationLine;
import com.cisco.b2b.model.InstallSiteLocation;
import com.cisco.b2b.model.MajorLine;
import com.cisco.b2b.model.PricingInformation;
import com.cisco.b2b.model.ProductAttributes;

public class ResponseComparator {

	public static List<CompareResult> compareConfigMajorLineResponse(MajorLine majorLine,
			ConfigurationLine configurationLine) {
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
			if (!pricingInformation.getUnitListPrice().equals(majorLine.getUnitListPrice())) {
				compareResults.add(createCompareResult(majorLine.getItemName(), "UnitListPrice",
						majorLine.getUnitListPrice(), pricingInformation.getUnitListPrice(), false));
			}
			if (!pricingInformation.getExtendedListPrice().equals(majorLine.getExtendedListPrice())) {
				compareResults.add(createCompareResult(majorLine.getItemName(), "ExtendedListPrice",
						majorLine.getExtendedListPrice(), pricingInformation.getExtendedListPrice(), false));
			}

		}

		InstallSiteLocation installSiteLocation = configurationLine.getInstallSiteLocation();
		Address address = installSiteLocation.getAddress();
		if (address != null) {
			if (address.getPostalCode() != null) {
				if (!address.getPostalCode().equals(majorLine.getInstallSite().getZipcode())) {
					compareResults.add(createCompareResult(majorLine.getItemName(), "MajorLine|InstallSite|Zipcode",
							majorLine.getInstallSite().getZipcode(), installSiteLocation.getAddress().getPostalCode(),
							false));
				}
			}
			if (!installSiteLocation.getAddress().getCountryCode().equals(majorLine.getInstallSite().getCountry())) {
				compareResults.add(createCompareResult(majorLine.getItemName(), "MajorLine|InstallSite|Country",
						majorLine.getInstallSite().getCountry(), installSiteLocation.getAddress().getCountryCode(),
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

		return compareResults;
	}

	private static CompareResult createCompareResult(String itemName, String propertyName, Object value1, Object value2,
			boolean result) {
		CompareResult compareResult = new CompareResult();
		compareResult.setItemName(itemName);
		compareResult.setPropertyName(propertyName);
		compareResult.setValue1(value1);
		compareResult.setValue2(value2);
		compareResult.setResult(false);
		return compareResult;
	}
}