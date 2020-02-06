package com.cisco.b2b.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class XaasAttributes {
	
	@JsonProperty("ActionCode")
	private String actionCode;
	
	@JsonProperty("RequestedStartDate")
	private String requestedStartDate;
	
	@JsonProperty("RequestedEndDate")
	private String requestedEndDate;
	
	@JsonProperty("InitialTerm")
	private String initialTerm;
	
	@JsonProperty("PrepayTerm")
	private String prepayTerm;
	
	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getRequestedStartDate() {
		return requestedStartDate;
	}

	public void setRequestedStartDate(String requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
	}

	public String getRequestedEndDate() {
		return requestedEndDate;
	}

	public void setRequestedEndDate(String requestedEndDate) {
		this.requestedEndDate = requestedEndDate;
	}

	public String getInitialTerm() {
		return initialTerm;
	}

	public void setInitialTerm(String initialTerm) {
		this.initialTerm = initialTerm;
	}

	public String getPrepayTerm() {
		return prepayTerm;
	}

	public void setPrepayTerm(String prepayTerm) {
		this.prepayTerm = prepayTerm;
	}

	public String getBillingModel() {
		return billingModel;
	}

	public void setBillingModel(String billingModel) {
		this.billingModel = billingModel;
	}

	public String getAutoRenewalTerm() {
		return autoRenewalTerm;
	}

	public void setAutoRenewalTerm(String autoRenewalTerm) {
		this.autoRenewalTerm = autoRenewalTerm;
	}

	public String getUsageQuantity() {
		return usageQuantity;
	}

	public void setUsageQuantity(String usageQuantity) {
		this.usageQuantity = usageQuantity;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getBillingType() {
		return billingType;
	}

	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	@JsonProperty("BillingModel")
	private String billingModel;
	
	@JsonProperty("AutoRenewalTerm")
	private String autoRenewalTerm;
	
	@JsonProperty("UsageQuantity")
	private String usageQuantity;
	
	@JsonProperty("ChargeType")
	private String chargeType;
	
	@JsonProperty("BillingType")
	private String billingType;
	
	@JsonProperty("UnitOfMeasure")
	private String unitOfMeasure;


}
