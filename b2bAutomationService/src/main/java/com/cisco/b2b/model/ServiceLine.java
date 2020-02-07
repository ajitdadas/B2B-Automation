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

	
	/****************/
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
	private List<Object> sourceLineId;
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
	private Integer quantity;
	@JsonProperty("unitListPrice")
	private Double unitListPrice;
	@JsonProperty("extendedListPrice")
	private Double extendedListPrice;
	@JsonProperty("description")
	private String description;
	@JsonProperty("mandatoryService")
	private Boolean mandatoryService;
	@JsonProperty("leadTime")
	private Integer leadTime;
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

	@JsonProperty("sourceLineId")
	public List<Object> getSourceLineId() {
		return sourceLineId;
	}

	@JsonProperty("sourceLineId")
	public void setSourceLineId(List<Object> sourceLineId) {
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

	@JsonProperty("quantity")
	public Integer getQuantity() {
		return quantity;
	}

	@JsonProperty("quantity")
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("unitListPrice")
	public Double getUnitListPrice() {
		return unitListPrice;
	}

	@JsonProperty("unitListPrice")
	public void setUnitListPrice(Double unitListPrice) {
		this.unitListPrice = unitListPrice;
	}

	@JsonProperty("extendedListPrice")
	public Double getExtendedListPrice() {
		return extendedListPrice;
	}

	@JsonProperty("extendedListPrice")
	public void setExtendedListPrice(Double extendedListPrice) {
		this.extendedListPrice = extendedListPrice;
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

	@JsonProperty("leadTime")
	public Integer getLeadTime() {
		return leadTime;
	}

	@JsonProperty("leadTime")
	public void setLeadTime(Integer leadTime) {
		this.leadTime = leadTime;
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