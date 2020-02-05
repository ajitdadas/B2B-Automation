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
