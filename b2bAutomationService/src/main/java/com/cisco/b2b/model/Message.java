package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	@JsonProperty("MessageCode")
	private String messageCode;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Severity")
	private String severity;

	@JsonProperty("ReasonCode")
	private String reasonCode;

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

}
