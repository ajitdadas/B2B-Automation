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
	
	public String gettAAIndicator() {
		return tAAIndicator;
	}

	public void settAAIndicator(String tAAIndicator) {
		this.tAAIndicator = tAAIndicator;
	}

	public String gettEPIndicator() {
		return tEPIndicator;
	}

	public void settEPIndicator(String tEPIndicator) {
		this.tEPIndicator = tEPIndicator;
	}

	public String getSmartAccountRequired() {
		return smartAccountRequired;
	}

	public void setSmartAccountRequired(String smartAccountRequired) {
		this.smartAccountRequired = smartAccountRequired;
	}

	public String getSmartAccountRequiredconfig() {
		return smartAccountRequiredconfig;
	}

	public void setSmartAccountRequiredconfig(String smartAccountRequiredconfig) {
		this.smartAccountRequiredconfig = smartAccountRequiredconfig;
	}

	public String getSmartEnabled() {
		return smartEnabled;
	}

	public void setSmartEnabled(String smartEnabled) {
		this.smartEnabled = smartEnabled;
	}

	public String getEquivalentCiscoOneSku() {
		return equivalentCiscoOneSku;
	}

	public void setEquivalentCiscoOneSku(String equivalentCiscoOneSku) {
		this.equivalentCiscoOneSku = equivalentCiscoOneSku;
	}

	public String getCiscoONETranslated() {
		return ciscoONETranslated;
	}

	public void setCiscoONETranslated(String ciscoONETranslated) {
		this.ciscoONETranslated = ciscoONETranslated;
	}

	public String gettAAFlag() {
		return tAAFlag;
	}

	public void settAAFlag(String tAAFlag) {
		this.tAAFlag = tAAFlag;
	}

	public String gettEPFlag() {
		return tEPFlag;
	}

	public void settEPFlag(String tEPFlag) {
		this.tEPFlag = tEPFlag;
	}

	public String getCryptoFlag() {
		return cryptoFlag;
	}

	public void setCryptoFlag(String cryptoFlag) {
		this.cryptoFlag = cryptoFlag;
	}

	public String getSmartLicense() {
		return smartLicense;
	}

	public void setSmartLicense(String smartLicense) {
		this.smartLicense = smartLicense;
	}

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
