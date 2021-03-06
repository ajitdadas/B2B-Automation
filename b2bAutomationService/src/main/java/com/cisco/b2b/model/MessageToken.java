package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageToken {
	
	@JsonProperty("name")
	private String name;
	

	@JsonProperty("value")
	private String value;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}

}
