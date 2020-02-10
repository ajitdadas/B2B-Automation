package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {
	
	@JsonProperty("key")
	private String key ;
	
	@JsonProperty("value")
	private String value ;
	
	@JsonProperty("@value")
	private String valueConfig ;
	
	@JsonProperty("@key")
	private String keyConfig ;

	public String getValueConfig() {
		return valueConfig;
	}

	public void setValueConfig(String valueConfig) {
		this.valueConfig = valueConfig;
	}

	public String getKeyConfig() {
		return keyConfig;
	}

	public void setKeyConfig(String keyConfig) {
		this.keyConfig = keyConfig;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
