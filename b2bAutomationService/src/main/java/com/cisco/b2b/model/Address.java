package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

	@JsonProperty("CountryCode")
	private String countryCode;

	@JsonProperty("PostalCode")
	private Object postalCode;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Address withCountryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	public Object getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Object postalCode) {
		this.postalCode = postalCode;
	}

	public Address withPostalCode(Object postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	@Override
	public String toString() {
		return "Address [countryCode=" + countryCode + ", postalCode=" + postalCode + "]";
	}
}
