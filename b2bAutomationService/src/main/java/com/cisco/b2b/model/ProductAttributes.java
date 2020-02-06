package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductAttributes {

	@JsonProperty("BundleFlag")
	private String bundleFlag;

	@JsonProperty("Serviceable")
	private String serviceable;

	@JsonProperty("DistiOrderableIndicator")
	private String distiOrderableIndicator;

	@JsonProperty("AllowedDifferentialDuration")
	private String allowedDifferentialDuration;
	
	@JsonProperty("TAAIndicator")
	private String tAAIndicator;
	
	@JsonProperty("TEPIndicator")
	private String tEPIndicator;

	
	@JsonProperty("SmartAccountRequired")
	private String smartAccountRequired;
	
	@JsonProperty("smartAccountRequired")
	private String smartAccountRequiredconfig;

	
	@JsonProperty("SmartEnabled")
	private String smartEnabled;
	
	@JsonProperty("EquivalentCiscoOneSku")
	private String equivalentCiscoOneSku;

	
	@JsonProperty("CiscoONETranslated")
	private String ciscoONETranslated;
	
	@JsonProperty("TAAFlag")
	private String tAAFlag;
	
	@JsonProperty("TEPFlag")
	private String tEPFlag;
	
	@JsonProperty("cryptoFlag")
	private String cryptoFlag;
	
	

	
	@JsonProperty("smartLicense")
	private String smartLicense;


	public String getBundleFlag() {
		return bundleFlag;
	}

	public void setBundleFlag(String bundleFlag) {
		this.bundleFlag = bundleFlag;
	}

	public String getServiceable() {
		return serviceable;
	}

	public void setServiceable(String serviceable) {
		this.serviceable = serviceable;
	}

	public String getDistiOrderableIndicator() {
		return distiOrderableIndicator;
	}

	public void setDistiOrderableIndicator(String distiOrderableIndicator) {
		this.distiOrderableIndicator = distiOrderableIndicator;
	}

	public String getAllowedDifferentialDuration() {
		return allowedDifferentialDuration;
	}

	public void setAllowedDifferentialDuration(String allowedDifferentialDuration) {
		this.allowedDifferentialDuration = allowedDifferentialDuration;
	}

	public ProductAttributes withAllowedDifferentialDuration(String allowedDifferentialDuration) {
		this.allowedDifferentialDuration = allowedDifferentialDuration;
		return this;
	}

	@Override
	public String toString() {
		return "ProductAttributes [bundleFlag=" + bundleFlag + ", serviceable=" + serviceable
				+ ", distiOrderableIndicator=" + distiOrderableIndicator + ", allowedDifferentialDuration="
				+ allowedDifferentialDuration + "]";
	}

}
