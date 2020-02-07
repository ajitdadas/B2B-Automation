package com.cisco.b2b.util;

public class CompareResult {
	private String itemName;
	private String propertyName;
	private Object configValue;
	private Object b2bValue;
	private boolean result;

	/****************/
	public CompareResult() {
		this.result = true;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Object getConfigValue() {
		return configValue;
	}

	public void setConfigValue(Object configValue) {
		this.configValue = configValue;
	}

	public Object getB2bValue() {
		return b2bValue;
	}

	public void setB2bValue(Object b2bValue) {
		this.b2bValue = b2bValue;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return " [itemName=" + itemName + ", propertyName=" + propertyName + ", configValue=" + configValue
				+ ", b2bValue=" + b2bValue + "]";
	}

}
