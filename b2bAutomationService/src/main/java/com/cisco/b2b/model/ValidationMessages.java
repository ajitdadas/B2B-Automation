package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationMessages {

	@JsonProperty("severity")
	private String severityconfig;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("message")
	private String message;
	
	public String getSeverityconfig() {
		return severityconfig;
	}

	public void setSeverityconfig(String severityconfig) {
		this.severityconfig = severityconfig;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
