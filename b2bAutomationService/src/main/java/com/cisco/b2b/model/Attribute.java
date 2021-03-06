package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attribute {

	@JsonProperty("@name")
	private String name;

	@JsonProperty("#text")
	private String text;
	
	@JsonProperty("value")
	private String value;
	
	@JsonProperty("name")
	private String nameCiscoOne;
	
	@JsonProperty("type")
	private String type;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		return "Attribute [name=" + name + ", text=" + text + "]";
	}

}
