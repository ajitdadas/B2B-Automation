package com.cisco.b2b.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class XaasMinorLine {



	@JsonProperty("actionTag")
	private String actionTag;
	@JsonProperty("usageQuantity")
	private Integer usageQuantity;
	@JsonProperty("uom")
	private String uom;
	@JsonProperty("billingType")
	private String billingType;
	@JsonProperty("chargeType")
	private String chargeType;
	@JsonProperty("xaasTermPayment")
	private XaasTermPayment xaasTermPayment;
	@JsonProperty("subscriptionUnit")
	private String subscriptionUnit;
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@JsonProperty("groupDescription")
	private String groupDescription;
	@JsonProperty("lineId")
	private Integer lineId;
	@JsonProperty("itemName")
	private String itemName;
	@JsonProperty("quantity")
	private Integer quantity;
	@JsonProperty("configPath")
	private String configPath;
	@JsonProperty("selectionFlag")
	private String selectionFlag;
	@JsonProperty("description")
	private String description;
	@JsonProperty("leadTime")
	private Integer leadTime;
	@JsonProperty("pricingInfo")
	private PricingInfo pricingInfo;
	@JsonProperty("uiHide")
	private Boolean uiHide;
	@JsonProperty("additionalItemInfo")
	private String additionalItemInfo;
	@JsonProperty("deliveryOption")
	private String deliveryOption;
	@JsonProperty("extendedAttributes")
	private ExtendedAttributes extendedAttributes;
	@JsonProperty("smartAccountRequired")
	private String smartAccountRequired;
	@JsonProperty("sourceLineId")
	private List<Integer> sourceLineId = null;
	@JsonProperty("message")
	private List<Object> message = null;
	@JsonProperty("serviceMapId")
	private Integer serviceMapId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("actionTag")
	public String getActionTag() {
		return actionTag;
	}

	@JsonProperty("actionTag")
	public void setActionTag(String actionTag) {
		this.actionTag = actionTag;
	}

	@JsonProperty("usageQuantity")
	public Integer getUsageQuantity() {
		return usageQuantity;
	}

	@JsonProperty("usageQuantity")
	public void setUsageQuantity(Integer usageQuantity) {
		this.usageQuantity = usageQuantity;
	}

	@JsonProperty("uom")
	public String getUom() {
		return uom;
	}

	@JsonProperty("uom")
	public void setUom(String uom) {
		this.uom = uom;
	}

	@JsonProperty("billingType")
	public String getBillingType() {
		return billingType;
	}

	@JsonProperty("billingType")
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	@JsonProperty("chargeType")
	public String getChargeType() {
		return chargeType;
	}

	@JsonProperty("chargeType")
	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	@JsonProperty("xaasTermPayment")
	public XaasTermPayment getXaasTermPayment() {
		return xaasTermPayment;
	}

	@JsonProperty("xaasTermPayment")
	public void setXaasTermPayment(XaasTermPayment xaasTermPayment) {
		this.xaasTermPayment = xaasTermPayment;
	}

	@JsonProperty("subscriptionUnit")
	public String getSubscriptionUnit() {
		return subscriptionUnit;
	}

	@JsonProperty("subscriptionUnit")
	public void setSubscriptionUnit(String subscriptionUnit) {
		this.subscriptionUnit = subscriptionUnit;
	}

	@JsonProperty("groupDescription")
	public String getGroupDescription() {
		return groupDescription;
	}

	@JsonProperty("groupDescription")
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	@JsonProperty("lineId")
	public Integer getLineId() {
		return lineId;
	}

	@JsonProperty("lineId")
	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	@JsonProperty("itemName")
	public String getItemName() {
		return itemName;
	}

	@JsonProperty("itemName")
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@JsonProperty("quantity")
	public Integer getQuantity() {
		return quantity;
	}

	@JsonProperty("quantity")
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("configPath")
	public String getConfigPath() {
		return configPath;
	}

	@JsonProperty("configPath")
	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	@JsonProperty("selectionFlag")
	public String getSelectionFlag() {
		return selectionFlag;
	}

	@JsonProperty("selectionFlag")
	public void setSelectionFlag(String selectionFlag) {
		this.selectionFlag = selectionFlag;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("leadTime")
	public Integer getLeadTime() {
		return leadTime;
	}

	@JsonProperty("leadTime")
	public void setLeadTime(Integer leadTime) {
		this.leadTime = leadTime;
	}

	@JsonProperty("pricingInfo")
	public PricingInfo getPricingInfo() {
		return pricingInfo;
	}

	@JsonProperty("pricingInfo")
	public void setPricingInfo(PricingInfo pricingInfo) {
		this.pricingInfo = pricingInfo;
	}

	@JsonProperty("uiHide")
	public Boolean getUiHide() {
		return uiHide;
	}

	@JsonProperty("uiHide")
	public void setUiHide(Boolean uiHide) {
		this.uiHide = uiHide;
	}

	@JsonProperty("additionalItemInfo")
	public String getAdditionalItemInfo() {
		return additionalItemInfo;
	}

	@JsonProperty("additionalItemInfo")
	public void setAdditionalItemInfo(String additionalItemInfo) {
		this.additionalItemInfo = additionalItemInfo;
	}

	@JsonProperty("deliveryOption")
	public String getDeliveryOption() {
		return deliveryOption;
	}

	@JsonProperty("deliveryOption")
	public void setDeliveryOption(String deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

	@JsonProperty("extendedAttributes")
	public ExtendedAttributes getExtendedAttributes() {
		return extendedAttributes;
	}

	@JsonProperty("extendedAttributes")
	public void setExtendedAttributes(ExtendedAttributes extendedAttributes) {
		this.extendedAttributes = extendedAttributes;
	}

	@JsonProperty("smartAccountRequired")
	public String getSmartAccountRequired() {
		return smartAccountRequired;
	}

	@JsonProperty("smartAccountRequired")
	public void setSmartAccountRequired(String smartAccountRequired) {
		this.smartAccountRequired = smartAccountRequired;
	}

	@JsonProperty("sourceLineId")
	public List<Integer> getSourceLineId() {
		return sourceLineId;
	}

	@JsonProperty("sourceLineId")
	public void setSourceLineId(List<Integer> sourceLineId) {
		this.sourceLineId = sourceLineId;
	}

	@JsonProperty("message")
	public List<Object> getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(List<Object> message) {
		this.message = message;
	}

	@JsonProperty("serviceMapId")
	public Integer getServiceMapId() {
		return serviceMapId;
	}

	@JsonProperty("serviceMapId")
	public void setServiceMapId(Integer serviceMapId) {
		this.serviceMapId = serviceMapId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "XaasMinorLine [actionTag=" + actionTag + ", usageQuantity=" + usageQuantity + ", uom=" + uom
				+ ", billingType=" + billingType + ", chargeType=" + chargeType + ", xaasTermPayment=" + xaasTermPayment
				+ ", subscriptionUnit=" + subscriptionUnit + ", groupDescription=" + groupDescription + ", lineId="
				+ lineId + ", itemName=" + itemName + ", quantity=" + quantity + ", configPath=" + configPath
				+ ", selectionFlag=" + selectionFlag + ", description=" + description + ", leadTime=" + leadTime
				+ ", pricingInfo=" + pricingInfo + ", uiHide=" + uiHide + ", additionalItemInfo=" + additionalItemInfo
				+ ", deliveryOption=" + deliveryOption + ", extendedAttributes=" + extendedAttributes
				+ ", smartAccountRequired=" + smartAccountRequired + ", sourceLineId=" + sourceLineId + ", message="
				+ message + ", serviceMapId=" + serviceMapId + ", additionalProperties=" + additionalProperties + "]";
	}

}
