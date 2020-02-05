package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstallSite {

	@JsonProperty("zipcode")
	private Object zipcode;

	@JsonProperty("country")
	private String country;

	public Object getZipcode() {
		return zipcode;
	}

	public void setZipcode(Object zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return "InstallSite [zipcode=" + zipcode + ", country=" + country + "]";
	}

}
