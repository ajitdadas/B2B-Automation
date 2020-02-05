
package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfigurationLine {

	@JsonProperty("LineNumber")
	private String lineNumber;
	@JsonProperty("ParentID")
	private String parentID;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Quantity")
	private String quantity;
	@JsonProperty("ItemName")
	private String itemName;
	@JsonProperty("PricingInformation")
	private PricingInformation pricingInformation;
	@JsonProperty("ItemType")
	private String itemType;
	@JsonProperty("InstallSiteLocation")
	private InstallSiteLocation installSiteLocation;
	@JsonProperty("LeadTime")
	private LeadTime leadTime;
	@JsonProperty("ProductAttributes")
	private ProductAttributes productAttributes;
	@JsonProperty("ConfigurationRecommendationAttributes")
	private ConfigurationRecommendationAttributes configurationRecommendationAttributes;

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public ConfigurationLine withLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
		return this;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public PricingInformation getPricingInformation() {
		return pricingInformation;
	}

	public void setPricingInformation(PricingInformation pricingInformation) {
		this.pricingInformation = pricingInformation;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public InstallSiteLocation getInstallSiteLocation() {
		return installSiteLocation;
	}

	public void setInstallSiteLocation(InstallSiteLocation installSiteLocation) {
		this.installSiteLocation = installSiteLocation;
	}

	public LeadTime getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(LeadTime leadTime) {
		this.leadTime = leadTime;
	}

	public ProductAttributes getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(ProductAttributes productAttributes) {
		this.productAttributes = productAttributes;
	}

	public ConfigurationRecommendationAttributes getConfigurationRecommendationAttributes() {
		return configurationRecommendationAttributes;
	}

	public void setConfigurationRecommendationAttributes(
			ConfigurationRecommendationAttributes configurationRecommendationAttributes) {
		this.configurationRecommendationAttributes = configurationRecommendationAttributes;
	}

	@Override
	public String toString() {
		return "ConfigurationLine [lineNumber=" + lineNumber + ", parentID=" + parentID + ", description=" + description
				+ ", quantity=" + quantity + ", itemName=" + itemName + ", pricingInformation=" + pricingInformation
				+ ", itemType=" + itemType + ", installSiteLocation=" + installSiteLocation + ", leadTime=" + leadTime
				+ ", productAttributes=" + productAttributes + ", configurationRecommendationAttributes="
				+ configurationRecommendationAttributes + "]";
	}
}
