package com.cisco.b2b.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "Sender", "Receiver", "CreationDateTime", "BODID", "ResponseStatus" })
public class B2BResponse {

	@JsonProperty("ConfigurationLine")
	private List<ConfigurationLine> configurationLine;

	@JsonProperty("ConfigurationLine")
	public List<ConfigurationLine> getConfigurationLine() {
		return configurationLine;
	}

	@JsonProperty("ConfigurationLine")
	public void setConfigurationLine(List<ConfigurationLine> configurationLine) {
		this.configurationLine = configurationLine;
	}

	public B2BResponse withConfigurationLine(List<ConfigurationLine> configurationLine) {
		this.configurationLine = configurationLine;
		return this;
	}

	@Override
	public String toString() {
		return "B2BResponse [configurationLine=" + configurationLine + "]";
	}

}
