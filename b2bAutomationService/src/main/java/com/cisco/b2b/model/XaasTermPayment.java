package com.cisco.b2b.model;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class XaasTermPayment {

@JsonProperty("requestedStartDate")
private BigInteger requestedStartDate;
@JsonProperty("startDate")
private BigInteger startDate;
@JsonProperty("endDate")
private BigInteger endDate;
@JsonProperty("initialTerm")
private String initialTerm;
@JsonProperty("defaultInitialTerm")
private String defaultInitialTerm;
@JsonProperty("autoRenewalTerm")
private String autoRenewalTerm;
@JsonProperty("defaultAutoRenewalTerm")
private String defaultAutoRenewalTerm;
@JsonProperty("prepayTerm")
private String prepayTerm;
@JsonProperty("billingModel")
private String billingModel;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();



public BigInteger getRequestedStartDate() {
	return requestedStartDate;
}

public void setRequestedStartDate(BigInteger requestedStartDate) {
	this.requestedStartDate = requestedStartDate;
}

public BigInteger getStartDate() {
	return startDate;
}

public void setStartDate(BigInteger startDate) {
	this.startDate = startDate;
}

public BigInteger getEndDate() {
	return endDate;
}

public void setEndDate(BigInteger endDate) {
	this.endDate = endDate;
}

public void setAdditionalProperties(Map<String, Object> additionalProperties) {
	this.additionalProperties = additionalProperties;
}

@JsonProperty("initialTerm")
public String getInitialTerm() {
return initialTerm;
}

@JsonProperty("initialTerm")
public void setInitialTerm(String initialTerm) {
this.initialTerm = initialTerm;
}

@JsonProperty("defaultInitialTerm")
public String getDefaultInitialTerm() {
return defaultInitialTerm;
}

@JsonProperty("defaultInitialTerm")
public void setDefaultInitialTerm(String defaultInitialTerm) {
this.defaultInitialTerm = defaultInitialTerm;
}

@JsonProperty("autoRenewalTerm")
public String getAutoRenewalTerm() {
return autoRenewalTerm;
}

@JsonProperty("autoRenewalTerm")
public void setAutoRenewalTerm(String autoRenewalTerm) {
this.autoRenewalTerm = autoRenewalTerm;
}

@JsonProperty("defaultAutoRenewalTerm")
public String getDefaultAutoRenewalTerm() {
return defaultAutoRenewalTerm;
}

@JsonProperty("defaultAutoRenewalTerm")
public void setDefaultAutoRenewalTerm(String defaultAutoRenewalTerm) {
this.defaultAutoRenewalTerm = defaultAutoRenewalTerm;
}

@JsonProperty("prepayTerm")
public String getPrepayTerm() {
return prepayTerm;
}

@JsonProperty("prepayTerm")
public void setPrepayTerm(String prepayTerm) {
this.prepayTerm = prepayTerm;
}

@JsonProperty("billingModel")
public String getBillingModel() {
return billingModel;
}

@JsonProperty("billingModel")
public void setBillingModel(String billingModel) {
this.billingModel = billingModel;
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