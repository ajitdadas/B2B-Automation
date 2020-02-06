package com.cisco.b2b.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class MinorLine {

@JsonProperty("configPath")
private String configPath;
@JsonProperty("selectionFlag")
private String selectionFlag;
@JsonProperty("default")
private Boolean _default;
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
private Integer quantity;
@JsonProperty("unitListPrice")
private Integer unitListPrice;
@JsonProperty("extendedListPrice")
private Integer extendedListPrice;
@JsonProperty("description")
private String description;
@JsonProperty("mandatoryService")
private Boolean mandatoryService;
@JsonProperty("orignalUnitListPrice")
private Integer orignalUnitListPrice;
@JsonProperty("leadTime")
private Integer leadTime;
@JsonProperty("serviceable")
private Boolean serviceable;
@JsonProperty("deliveryOption")
private String deliveryOption;
@JsonProperty("uiHide")
private Boolean uiHide;
@JsonProperty("distiOnly")
private Boolean distiOnly;
@JsonProperty("allowedDifferentialDuration")
private Boolean allowedDifferentialDuration;
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
public Boolean get_default() {
	return _default;
}
public void set_default(Boolean _default) {
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
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public Integer getUnitListPrice() {
	return unitListPrice;
}
public void setUnitListPrice(Integer unitListPrice) {
	this.unitListPrice = unitListPrice;
}
public Integer getExtendedListPrice() {
	return extendedListPrice;
}
public void setExtendedListPrice(Integer extendedListPrice) {
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
public Boolean getServiceable() {
	return serviceable;
}
public void setServiceable(Boolean serviceable) {
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
public Boolean getAllowedDifferentialDuration() {
	return allowedDifferentialDuration;
}
public void setAllowedDifferentialDuration(Boolean allowedDifferentialDuration) {
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