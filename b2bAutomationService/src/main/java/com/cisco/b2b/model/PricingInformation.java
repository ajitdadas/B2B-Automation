package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PricingInformation {

	@JsonProperty("UnitListPrice")
	private String unitListPrice;

	@JsonProperty("CurrencyCode")
	private String currencyCode;

	@JsonProperty("PerQuantity")
	private String perQuantity;

	@JsonProperty("ExtendedListPrice")
	private String extendedListPrice;

	public String getUnitListPrice() {
		return unitListPrice;
	}

	public void setUnitListPrice(String unitListPrice) {
		this.unitListPrice = unitListPrice;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getPerQuantity() {
		return perQuantity;
	}

	public void setPerQuantity(String perQuantity) {
		this.perQuantity = perQuantity;
	}

	public String getExtendedListPrice() {
		return extendedListPrice;
	}

	public void setExtendedListPrice(String extendedListPrice) {
		this.extendedListPrice = extendedListPrice;
	}

	public String toString() {
		return "PricingInformation [unitListPrice=" + unitListPrice + ", currencyCode=" + currencyCode
				+ ", perQuantity=" + perQuantity + ", extendedListPrice=" + extendedListPrice + "]";
	}

}
