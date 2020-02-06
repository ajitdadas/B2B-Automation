
package com.cisco.b2b.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

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

	@JsonProperty("ConfigPath")
	private String configPath;
	
	@JsonProperty("SourceLineID")
	private String sourceLineID;
	
	@JsonProperty("ConfigReference")
	private String configReference;
	
	@JsonProperty("Message")
	private JsonNode message;
	
	@JsonProperty("SelectionCode")
	private String selectionCode;
	
	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("ServiceAttributes")
	private ServiceAttributes serviceAttributes;
	
	@JsonProperty("Default")
	private String default_;
	
	@JsonProperty("XaasAttributes")
	private XaasAttributes xaasAttributes;

	public String getConfigPath() {
		return configPath;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	public String getSourceLineID() {
		return sourceLineID;
	}

	public void setSourceLineID(String sourceLineID) {
		this.sourceLineID = sourceLineID;
	}

	public String getConfigReference() {
		return configReference;
	}

	public void setConfigReference(String configReference) {
		this.configReference = configReference;
	}

	public String getSelectionCode() {
		return selectionCode;
	}

	public void setSelectionCode(String selectionCode) {
		this.selectionCode = selectionCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ServiceAttributes getServiceAttributes() {
		return serviceAttributes;
	}

	public void setServiceAttributes(ServiceAttributes serviceAttributes) {
		this.serviceAttributes = serviceAttributes;
	}

	public String getDefault_() {
		return default_;
	}

	public void setDefault_(String default_) {
		this.default_ = default_;
	}

	public XaasAttributes getXaasAttributes() {
		return xaasAttributes;
	}

	public void setXaasAttributes(XaasAttributes xaasAttributes) {
		this.xaasAttributes = xaasAttributes;
	}

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

	public JsonNode getMessage() {
		return message;
	}

	public void setMessage(JsonNode message) {
		this.message = message;
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
