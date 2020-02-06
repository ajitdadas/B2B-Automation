package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReferenceSKU {
	
	@JsonProperty("skuName")
	private String skuName;
	
	@JsonProperty("unitListPrice")
	private String unitListPrice;

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getUnitListPrice() {
		return unitListPrice;
	}

	public void setUnitListPrice(String unitListPrice) {
		this.unitListPrice = unitListPrice;
	}
	
	
	
	

}
