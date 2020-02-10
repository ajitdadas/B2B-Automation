package com.cisco.b2b.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MajorLine {

	
	/****************/
	@JsonProperty("itemName")
	private String itemName;

	@JsonProperty("configId")
	private String configId;

	@JsonProperty("autoAddC1")
	private String autoAddC1;

	@JsonProperty("itemType")
	private String itemType;

	@JsonProperty("quantity")
	private String quantity;

	@JsonProperty("unitListPrice")
	private BigDecimal unitListPrice;

	@JsonProperty("extendedListPrice")
	private BigDecimal extendedListPrice;

	@JsonProperty("description")
	private String description;

	@JsonProperty("orignalUnitListPrice")
	private String orignalUnitListPrice;

	@JsonProperty("serviceable")
	private String serviceable;

	@JsonProperty("additionalItemInfo")
	private String additionalItemInfo;

	@JsonProperty("selectionFlag")
	private String selectionFlag;

	@JsonProperty("status")
	private String status;

	@JsonProperty("installSite")
	private InstallSite installSiteLocation;

	@JsonProperty("flexServiceDuration")
	private String flexServiceDuration;

	@JsonProperty("extendedAttributes")
	private ExtendedAttributes extendedAttributes;

	@JsonProperty("message")
	private List<Message> messages;

	@JsonProperty("serviceLine")
	private List<ServiceLine> serviceLine;

	@JsonProperty("bundleFlag")
	private String bundleFlag;

	@JsonProperty("configPath")
	private String configPath;

	@JsonProperty("configValidationTimeStamp")
	private String configValidationTimeStamp;

	@JsonProperty("productAttributes")
	private ProductAttributes productAttributes;

	@JsonProperty("minorLine")
	private List<MinorLine> minorLine;

	@JsonProperty("referenceSKU")
	private List<ReferenceSKU> referenceSKU;

	@JsonProperty("xaasMinorLine")
	private List<XaasMinorLine> xaasMinorLine;

	@JsonProperty("actionTag")
	private String actionTag;

	@JsonProperty("lineId")
	private String lineId;

	@JsonProperty("mandatoryService")
	private String mandatoryService;

	@JsonProperty("leadTime")
	private String leadTime;

	@JsonProperty("deliveryOption")
	private String deliveryOption;

	@JsonProperty("uiHide")
	private String uiHide;

	@JsonProperty("distiOnly")
	private String distiOnly;

	@JsonProperty("allowedDifferentialDuration")
	private String allowedDifferentialDuration;

	@JsonProperty("serviceMapId")
	private String serviceMapId;

	@JsonProperty("validationMessages")
	private List<ValidationMessages> validationMessages;

	@JsonProperty("sourceLineId")
	private List<String> sourceLineId;

	@JsonProperty("ciscoOneSKU")
	private String ciscoOneSKU;
	
	@JsonProperty("flexTermsPayments")
	private String flexTermsPayments;
	
	@JsonProperty("servicePreference")
	private ServicePreference servicePreference;
	
	public String getCiscoOneSKU() {
		return ciscoOneSKU;
	}

	public void setCiscoOneSKU(String ciscoOneSKU) {
		this.ciscoOneSKU = ciscoOneSKU;
	}

	public String getFlexTermsPayments() {
		return flexTermsPayments;
	}

	public void setFlexTermsPayments(String flexTermsPayments) {
		this.flexTermsPayments = flexTermsPayments;
	}

	public ServicePreference getServicePreference() {
		return servicePreference;
	}

	public void setServicePreference(ServicePreference servicePreference) {
		this.servicePreference = servicePreference;
	}

	public String getDisplayConfig() {
		return displayConfig;
	}

	public void setDisplayConfig(String displayConfig) {
		this.displayConfig = displayConfig;
	}

	public List<AssociatedHWProducts> getAssociatedHWProducts() {
		return associatedHWProducts;
	}

	public void setAssociatedHWProducts(List<AssociatedHWProducts> associatedHWProducts) {
		this.associatedHWProducts = associatedHWProducts;
	}

	@JsonProperty("displayConfig")
	private String displayConfig;
	
	@JsonProperty("associatedHWProducts")
	private List<AssociatedHWProducts> associatedHWProducts;


	public List<ReferenceSKU> getReferenceSKU() {
		return referenceSKU;
	}

	public void setReferenceSKU(List<ReferenceSKU> referenceSKU) {
		this.referenceSKU = referenceSKU;
	}

	public List<XaasMinorLine> getXaasMinorLine() {
		return xaasMinorLine;
	}

	public void setXaasMinorLine(List<XaasMinorLine> xaasMinorLine) {
		this.xaasMinorLine = xaasMinorLine;
	}

	public String getActionTag() {
		return actionTag;
	}

	public void setActionTag(String actionTag) {
		this.actionTag = actionTag;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getMandatoryService() {
		return mandatoryService;
	}

	public void setMandatoryService(String mandatoryService) {
		this.mandatoryService = mandatoryService;
	}

	public String getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}

	public String getDeliveryOption() {
		return deliveryOption;
	}

	public void setDeliveryOption(String deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

	public String getUiHide() {
		return uiHide;
	}

	public void setUiHide(String uiHide) {
		this.uiHide = uiHide;
	}

	public String getDistiOnly() {
		return distiOnly;
	}

	public void setDistiOnly(String distiOnly) {
		this.distiOnly = distiOnly;
	}

	public String getAllowedDifferentialDuration() {
		return allowedDifferentialDuration;
	}

	public void setAllowedDifferentialDuration(String allowedDifferentialDuration) {
		this.allowedDifferentialDuration = allowedDifferentialDuration;
	}

	public String getServiceMapId() {
		return serviceMapId;
	}

	public void setServiceMapId(String serviceMapId) {
		this.serviceMapId = serviceMapId;
	}

	public List<ValidationMessages> getValidationMessages() {
		return validationMessages;
	}

	public void setValidationMessages(List<ValidationMessages> validationMessages) {
		this.validationMessages = validationMessages;
	}

	public InstallSite getInstallSiteLocation() {
		return installSiteLocation;
	}

	public void setInstallSiteLocation(InstallSite installSiteLocation) {
		this.installSiteLocation = installSiteLocation;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<String> getSourceLineId() {
		return sourceLineId;
	}

	public void setSourceLineId(List<String> sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	public List<MinorLine> getMinorLine() {
		return minorLine;
	}

	public void setMinorLine(List<MinorLine> minorLine) {
		this.minorLine = minorLine;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrignalUnitListPrice() {
		return orignalUnitListPrice;
	}

	public void setOrignalUnitListPrice(String orignalUnitListPrice) {
		this.orignalUnitListPrice = orignalUnitListPrice;
	}

	public String getServiceable() {
		return serviceable;
	}

	public void setServiceable(String serviceable) {
		this.serviceable = serviceable;
	}

	public String getAdditionalItemInfo() {
		return additionalItemInfo;
	}

	public void setAdditionalItemInfo(String additionalItemInfo) {
		this.additionalItemInfo = additionalItemInfo;
	}

	public String getSelectionFlag() {
		return selectionFlag;
	}

	public void setSelectionFlag(String selectionFlag) {
		this.selectionFlag = selectionFlag;
	}

	public List<ServiceLine> getServiceLine() {
		return serviceLine;
	}

	public void setServiceLine(List<ServiceLine> serviceLine) {
		this.serviceLine = serviceLine;
	}

	public String getBundleFlag() {
		return bundleFlag;
	}

	public void setBundleFlag(String bundleFlag) {
		this.bundleFlag = bundleFlag;
	}

	public String getConfigPath() {
		return configPath;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	public String getConfigValidationTimeStamp() {
		return configValidationTimeStamp;
	}

	public void setConfigValidationTimeStamp(String configValidationTimeStamp) {
		this.configValidationTimeStamp = configValidationTimeStamp;
	}

	public ProductAttributes getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(ProductAttributes productAttributes) {
		this.productAttributes = productAttributes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlexServiceDuration() {
		return flexServiceDuration;
	}

	public void setFlexServiceDuration(String flexServiceDuration) {
		this.flexServiceDuration = flexServiceDuration;
	}

	public ExtendedAttributes getExtendedAttributes() {
		return extendedAttributes;
	}

	public void setExtendedAttributes(ExtendedAttributes extendedAttributes) {
		this.extendedAttributes = extendedAttributes;
	}

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public String getAutoAddC1() {
		return autoAddC1;
	}

	public void setAutoAddC1(String autoAddC1) {
		this.autoAddC1 = autoAddC1;
	}

	public String toString() {
		return "MajorLines [itemName=" + itemName + ", itemType=" + itemType + ", quantity=" + quantity
				+ ", unitListPrice=" + unitListPrice + ", extendedListPrice=" + extendedListPrice + ", description="
				+ description + ", orignalUnitListPrice=" + orignalUnitListPrice + ", serviceable=" + serviceable
				+ ", additionalItemInfo=" + additionalItemInfo + ", selectionFlag=" + selectionFlag + ", status="
				+ status + ", installSiteLocation=" + installSiteLocation + ", flexServiceDuration="
				+ flexServiceDuration + ", extendedAttributes=" + extendedAttributes + "]";
	}

}