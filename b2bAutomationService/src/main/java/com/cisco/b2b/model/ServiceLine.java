package com.cisco.b2b.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceLine {

	@JsonProperty("serviceLevelName")
	private String serviceLevelName;
	@JsonProperty("durationListPrice")
	private BigDecimal durationListPrice;
	@JsonProperty("servicePeriod")
	private ServicePeriod servicePeriod;
	@JsonProperty("lessThanMinDur")
	private String lessThanMinDur;
	@JsonProperty("hierarchy")
	private String hierarchy;
	@JsonProperty("userSelected")
	private Boolean userSelected;
	@JsonProperty("taxMandatoryAttach")
	private Boolean taxMandatoryAttach;
	@JsonProperty("durationList")
	private List<Integer> durationList = null;
	@JsonProperty("sourceLineId")
	private List<String> sourceLineId;
	@JsonProperty("message")
	private List<Object> message = null;
	@JsonProperty("serviceLine")
	private List<ServiceLine> serviceLine = null;
	@JsonProperty("mnqAttributes")
	private MnqAttributes mnqAttributes;
	@JsonProperty("serviceAttributes")
	private ServiceAttributes serviceAttributes;
	@JsonProperty("extendedAttributes")
	private ExtendedAttributes extendedAttributes;
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
	@JsonProperty("leadTime")
	private String leadTime;
	@JsonProperty("serviceMapId")
	private Integer serviceMapId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("serviceLevelName")
	public String getServiceLevelName() {
		return serviceLevelName;
	}

	@JsonProperty("serviceLevelName")
	public void setServiceLevelName(String serviceLevelName) {
		this.serviceLevelName = serviceLevelName;
	}

	
	public BigDecimal getDurationListPrice() {
		return durationListPrice;
	}

	public void setDurationListPrice(BigDecimal durationListPrice) {
		this.durationListPrice = durationListPrice;
	}

	@JsonProperty("servicePeriod")
	public ServicePeriod getServicePeriod() {
		return servicePeriod;
	}

	@JsonProperty("servicePeriod")
	public void setServicePeriod(ServicePeriod servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	@JsonProperty("lessThanMinDur")
	public String getLessThanMinDur() {
		return lessThanMinDur;
	}

	@JsonProperty("lessThanMinDur")
	public void setLessThanMinDur(String lessThanMinDur) {
		this.lessThanMinDur = lessThanMinDur;
	}

	@JsonProperty("hierarchy")
	public String getHierarchy() {
		return hierarchy;
	}

	@JsonProperty("hierarchy")
	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	@JsonProperty("userSelected")
	public Boolean getUserSelected() {
		return userSelected;
	}

	@JsonProperty("userSelected")
	public void setUserSelected(Boolean userSelected) {
		this.userSelected = userSelected;
	}

	@JsonProperty("taxMandatoryAttach")
	public Boolean getTaxMandatoryAttach() {
		return taxMandatoryAttach;
	}

	@JsonProperty("taxMandatoryAttach")
	public void setTaxMandatoryAttach(Boolean taxMandatoryAttach) {
		this.taxMandatoryAttach = taxMandatoryAttach;
	}

	@JsonProperty("durationList")
	public List<Integer> getDurationList() {
		return durationList;
	}

	@JsonProperty("durationList")
	public void setDurationList(List<Integer> durationList) {
		this.durationList = durationList;
	}

	public List<String> getSourceLineId() {
		return sourceLineId;
	}

	public void setSourceLineId(List<String> sourceLineId) {
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

	public List<ServiceLine> getServiceLine() {
		return serviceLine;
	}

	public void setServiceLine(List<ServiceLine> serviceLine) {
		this.serviceLine = serviceLine;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	@JsonProperty("mnqAttributes")
	public MnqAttributes getMnqAttributes() {
		return mnqAttributes;
	}

	@JsonProperty("mnqAttributes")
	public void setMnqAttributes(MnqAttributes mnqAttributes) {
		this.mnqAttributes = mnqAttributes;
	}

	@JsonProperty("serviceAttributes")
	public ServiceAttributes getServiceAttributes() {
		return serviceAttributes;
	}

	@JsonProperty("serviceAttributes")
	public void setServiceAttributes(ServiceAttributes serviceAttributes) {
		this.serviceAttributes = serviceAttributes;
	}

	@JsonProperty("extendedAttributes")
	public ExtendedAttributes getExtendedAttributes() {
		return extendedAttributes;
	}

	@JsonProperty("extendedAttributes")
	public void setExtendedAttributes(ExtendedAttributes extendedAttributes) {
		this.extendedAttributes = extendedAttributes;
	}

	@JsonProperty("itemName")
	public String getItemName() {
		return itemName;
	}

	@JsonProperty("itemName")
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@JsonProperty("itemType")
	public String getItemType() {
		return itemType;
	}

	@JsonProperty("itemType")
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	
	@Override
	public String toString() {
		return "ServiceLine [serviceLevelName=" + serviceLevelName + ", durationListPrice=" + durationListPrice
				+ ", servicePeriod=" + servicePeriod + ", lessThanMinDur=" + lessThanMinDur + ", hierarchy=" + hierarchy
				+ ", userSelected=" + userSelected + ", taxMandatoryAttach=" + taxMandatoryAttach + ", durationList="
				+ durationList + ", sourceLineId=" + sourceLineId + ", message=" + message + ", serviceLine="
				+ serviceLine + ", mnqAttributes=" + mnqAttributes + ", serviceAttributes=" + serviceAttributes
				+ ", extendedAttributes=" + extendedAttributes + ", itemName=" + itemName + ", itemType=" + itemType
				+ ", quantity=" + quantity + ", unitListPrice=" + unitListPrice + ", extendedListPrice="
				+ extendedListPrice + ", description=" + description + ", mandatoryService=" + mandatoryService
				+ ", leadTime=" + leadTime + ", serviceMapId=" + serviceMapId + ", additionalProperties="
				+ additionalProperties + "]";
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

	public String getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("mandatoryService")
	public Boolean getMandatoryService() {
		return mandatoryService;
	}

	@JsonProperty("mandatoryService")
	public void setMandatoryService(Boolean mandatoryService) {
		this.mandatoryService = mandatoryService;
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

}