package com.cisco.b2b.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PricingInformation {

	@JsonProperty("UnitListPrice")
	private BigDecimal unitListPrice;

	@JsonProperty("CurrencyCode")
	private String currencyCode;

	@JsonProperty("PerQuantity")
	private String perQuantity;

	@JsonProperty("ExtendedListPrice")
	private BigDecimal extendedListPrice;

	public BigDecimal getUnitListPrice() {
		return unitListPrice;
	}

	public void setUnitListPrice(BigDecimal unitListPrice) {
		this.unitListPrice = unitListPrice;
	}

	public BigDecimal getExtendedListPrice() {
		return extendedListPrice;
	}

	public void setExtendedListPrice(BigDecimal extendedListPrice) {
		this.extendedListPrice = extendedListPrice;
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

	

	public String toString() {
		return "PricingInformation [unitListPrice=" + unitListPrice + ", currencyCode=" + currencyCode
				+ ", perQuantity=" + perQuantity + ", extendedListPrice=" + extendedListPrice + "]";
	}

}
