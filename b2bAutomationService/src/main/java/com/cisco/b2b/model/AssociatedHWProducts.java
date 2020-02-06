package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssociatedHWProducts {

	@JsonProperty("itemName")
	private String itemName;
	
	@JsonProperty("itemGroup")
	private String itemGroup;
	
	@JsonProperty("description")
	private String description;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
