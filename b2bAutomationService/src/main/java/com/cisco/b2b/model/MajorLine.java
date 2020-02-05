package com.cisco.b2b.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MajorLine {

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public InstallSite getInstallSite() {
		return installSiteLocation;
	}

	public void setInstallSite(InstallSite installSite) {
		this.installSiteLocation = installSite;
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

	public String toString() {
		return "MajorLine [itemName=" + itemName + ", itemType=" + itemType + ", quantity=" + quantity
				+ ", unitListPrice=" + unitListPrice + ", extendedListPrice=" + extendedListPrice + ", description="
				+ description + ", orignalUnitListPrice=" + orignalUnitListPrice + ", serviceable=" + serviceable
				+ ", additionalItemInfo=" + additionalItemInfo + ", selectionFlag=" + selectionFlag + ", status="
				+ status + ", installSiteLocation=" + installSiteLocation + ", flexServiceDuration="
				+ flexServiceDuration + ", extendedAttributes=" + extendedAttributes + "]";
	}

}
