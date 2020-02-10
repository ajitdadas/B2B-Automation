package com.cisco.b2b.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class MinorLine {

	@JsonProperty("configPath")
	private String configPath;
	@JsonProperty("selectionFlag")
	private String selectionFlag;
	@JsonProperty("default")
	private String _default;
	@JsonProperty("productAttributes")
	private ProductAttributes productAttributes;
	@JsonProperty("serviceLine")
	private List<ServiceLine> serviceLine = null;
	@JsonProperty("extendedAttributes")
	private ExtendedAttributes extendedAttributes;
	@JsonProperty("lineId")
	private Integer lineId;
	@JsonProperty("itemName")
	private String itemName;
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
	@JsonProperty("mandatoryService")
	private Boolean mandatoryService;
	@JsonProperty("orignalUnitListPrice")
	private Integer orignalUnitListPrice;
	@JsonProperty("leadTime")
	private Integer leadTime;
	@JsonProperty("serviceable")
	private String serviceable;
	@JsonProperty("deliveryOption")
	private String deliveryOption;
	@JsonProperty("uiHide")
	private Boolean uiHide;
	@JsonProperty("distiOnly")
	private Boolean distiOnly;
	@JsonProperty("allowedDifferentialDuration")
	private String allowedDifferentialDuration;
	@JsonProperty("validationMessages")
	private List<Object> validationMessages = null;
	@JsonProperty("serviceMapId")
	private Integer serviceMapId;
	@JsonProperty("sourceLineId")
	private List<Integer> sourceLineId = null;
	@JsonProperty("message")
	private List<Message> message = null;
	@JsonProperty("additionalItemInfo")
	private String additionalItemInfo;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	public String getConfigPath() {
		return configPath;
	}
	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}
	public String getSelectionFlag() {
		return selectionFlag;
	}
	public void setSelectionFlag(String selectionFlag) {
		this.selectionFlag = selectionFlag;
	}
	
	public String get_default() {
		return _default;
	}
	public void set_default(String _default) {
		this._default = _default;
	}
	public ProductAttributes getProductAttributes() {
		return productAttributes;
	}
	public void setProductAttributes(ProductAttributes productAttributes) {
		this.productAttributes = productAttributes;
	}
	public List<ServiceLine> getServiceLine() {
		return serviceLine;
	}
	public void setServiceLine(List<ServiceLine> serviceLine) {
		this.serviceLine = serviceLine;
	}
	public ExtendedAttributes getExtendedAttributes() {
		return extendedAttributes;
	}
	public void setExtendedAttributes(ExtendedAttributes extendedAttributes) {
		this.extendedAttributes = extendedAttributes;
	}
	public Integer getLineId() {
		return lineId;
	}
	public void setLineId(Integer lineId) {
		this.lineId = lineId;
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
	@Override
	public String toString() {
		return "MinorLine [configPath=" + configPath + ", selectionFlag=" + selectionFlag + ", _default=" + _default
				+ ", productAttributes=" + productAttributes + ", serviceLine=" + serviceLine + ", extendedAttributes="
				+ extendedAttributes + ", lineId=" + lineId + ", itemName=" + itemName + ", itemType=" + itemType
				+ ", quantity=" + quantity + ", unitListPrice=" + unitListPrice + ", extendedListPrice="
				+ extendedListPrice + ", description=" + description + ", mandatoryService=" + mandatoryService
				+ ", orignalUnitListPrice=" + orignalUnitListPrice + ", leadTime=" + leadTime + ", serviceable="
				+ serviceable + ", deliveryOption=" + deliveryOption + ", uiHide=" + uiHide + ", distiOnly=" + distiOnly
				+ ", allowedDifferentialDuration=" + allowedDifferentialDuration + ", validationMessages="
				+ validationMessages + ", serviceMapId=" + serviceMapId + ", sourceLineId=" + sourceLineId
				+ ", message=" + message + ", additionalItemInfo=" + additionalItemInfo + ", additionalProperties="
				+ additionalProperties + "]";
	}
	public BigDecimal getUnitListPrice() {
		return unitListPrice;
	}
	public BigDecimal getExtendedListPrice() {
		return extendedListPrice;
	}
	public void setUnitListPrice(BigDecimal unitListPrice) {
		this.unitListPrice = unitListPrice;
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
	public Boolean getMandatoryService() {
		return mandatoryService;
	}
	public void setMandatoryService(Boolean mandatoryService) {
		this.mandatoryService = mandatoryService;
	}
	public Integer getOrignalUnitListPrice() {
		return orignalUnitListPrice;
	}
	public void setOrignalUnitListPrice(Integer orignalUnitListPrice) {
		this.orignalUnitListPrice = orignalUnitListPrice;
	}
	public Integer getLeadTime() {
		return leadTime;
	}
	public void setLeadTime(Integer leadTime) {
		this.leadTime = leadTime;
	}
	
	public String getServiceable() {
		return serviceable;
	}
	public void setServiceable(String serviceable) {
		this.serviceable = serviceable;
	}
	public String getDeliveryOption() {
		return deliveryOption;
	}
	public void setDeliveryOption(String deliveryOption) {
		this.deliveryOption = deliveryOption;
	}
	public Boolean getUiHide() {
		return uiHide;
	}
	public void setUiHide(Boolean uiHide) {
		this.uiHide = uiHide;
	}
	public Boolean getDistiOnly() {
		return distiOnly;
	}
	public void setDistiOnly(Boolean distiOnly) {
		this.distiOnly = distiOnly;
	}
	
	public String getAllowedDifferentialDuration() {
		return allowedDifferentialDuration;
	}
	public void setAllowedDifferentialDuration(String allowedDifferentialDuration) {
		this.allowedDifferentialDuration = allowedDifferentialDuration;
	}
	public List<Object> getValidationMessages() {
		return validationMessages;
	}
	public void setValidationMessages(List<Object> validationMessages) {
		this.validationMessages = validationMessages;
	}
	public Integer getServiceMapId() {
		return serviceMapId;
	}
	public void setServiceMapId(Integer serviceMapId) {
		this.serviceMapId = serviceMapId;
	}
	public List<Integer> getSourceLineId() {
		return sourceLineId;
	}
	public void setSourceLineId(List<Integer> sourceLineId) {
		this.sourceLineId = sourceLineId;
	}
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	public String getAdditionalItemInfo() {
		return additionalItemInfo;
	}
	public void setAdditionalItemInfo(String additionalItemInfo) {
		this.additionalItemInfo = additionalItemInfo;
	}
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}



}