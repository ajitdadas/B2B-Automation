package com.cisco.b2b.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class PricingInfo {

@JsonProperty("unitListPrice")
private Integer unitListPrice;
@JsonProperty("unitListPriceQty")
private Integer unitListPriceQty;
@JsonProperty("durationListPrice")
private Integer durationListPrice;
@JsonProperty("extendedListPrice")
private Integer extendedListPrice;
@JsonProperty("orignalUnitListPrice")
private Integer orignalUnitListPrice;
@JsonProperty("decimalExp")
private Integer decimalExp;
@JsonProperty("listPriceVersion")
private String listPriceVersion;
@JsonProperty("pricingTerm")
private Integer pricingTerm;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("unitListPrice")
public Integer getUnitListPrice() {
return unitListPrice;
}

@JsonProperty("unitListPrice")
public void setUnitListPrice(Integer unitListPrice) {
this.unitListPrice = unitListPrice;
}

@JsonProperty("unitListPriceQty")
public Integer getUnitListPriceQty() {
return unitListPriceQty;
}

@JsonProperty("unitListPriceQty")
public void setUnitListPriceQty(Integer unitListPriceQty) {
this.unitListPriceQty = unitListPriceQty;
}

@JsonProperty("durationListPrice")
public Integer getDurationListPrice() {
return durationListPrice;
}

@JsonProperty("durationListPrice")
public void setDurationListPrice(Integer durationListPrice) {
this.durationListPrice = durationListPrice;
}

@JsonProperty("extendedListPrice")
public Integer getExtendedListPrice() {
return extendedListPrice;
}

@JsonProperty("extendedListPrice")
public void setExtendedListPrice(Integer extendedListPrice) {
this.extendedListPrice = extendedListPrice;
}

@JsonProperty("orignalUnitListPrice")
public Integer getOrignalUnitListPrice() {
return orignalUnitListPrice;
}

@JsonProperty("orignalUnitListPrice")
public void setOrignalUnitListPrice(Integer orignalUnitListPrice) {
this.orignalUnitListPrice = orignalUnitListPrice;
}

@JsonProperty("decimalExp")
public Integer getDecimalExp() {
return decimalExp;
}

@JsonProperty("decimalExp")
public void setDecimalExp(Integer decimalExp) {
this.decimalExp = decimalExp;
}

@JsonProperty("listPriceVersion")
public String getListPriceVersion() {
return listPriceVersion;
}

@JsonProperty("listPriceVersion")
public void setListPriceVersion(String listPriceVersion) {
this.listPriceVersion = listPriceVersion;
}

@JsonProperty("pricingTerm")
public Integer getPricingTerm() {
return pricingTerm;
}

@JsonProperty("pricingTerm")
public void setPricingTerm(Integer pricingTerm) {
this.pricingTerm = pricingTerm;
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