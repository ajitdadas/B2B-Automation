package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstallSiteLocation {

	@JsonProperty("Address")
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "InstallSiteLocation [address=" + address + "]";
	}

}
