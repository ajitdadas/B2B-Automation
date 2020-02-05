package com.cisco.b2b.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtendedAttributes {

	@JsonProperty("attribute")
	private List<Attribute> attribute = new ArrayList<Attribute>();

	@JsonIgnore

	public List<Attribute> getAttribute() {
		return attribute;
	}

	public void setAttribute(List<Attribute> attribute) {
		this.attribute = attribute;
	}

	@Override
	public String toString() {
		return "ExtendedAttributes [attribute=" + attribute + "]";
	}

}
