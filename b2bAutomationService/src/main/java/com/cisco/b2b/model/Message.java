package com.cisco.b2b.model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreType;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreType
public class Message {
	@JsonProperty("MessageCode")
	private String messageCode;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Severity")
	private String severity;

	@JsonProperty("ReasonCode")
	private String reasonCode;
	
	@JsonProperty("code")
	private String code;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescriptionconfig() {
		return descriptionconfig;
	}

	public void setDescriptionconfig(String descriptionconfig) {
		this.descriptionconfig = descriptionconfig;
	}

	public List<MessageToken> getMessageToken() {
		return messageToken;
	}

	public void setMessageToken(List<MessageToken> messageToken) {
		this.messageToken = messageToken;
	}

	public String getSeverityconfig() {
		return severityconfig;
	}

	public void setSeverityconfig(String severityconfig) {
		this.severityconfig = severityconfig;
	}

	public String getCauseconfig() {
		return causeconfig;
	}

	public void setCauseconfig(String causeconfig) {
		this.causeconfig = causeconfig;
	}

	public String getSubCause() {
		return subCause;
	}

	public void setSubCause(String subCause) {
		this.subCause = subCause;
	}

	@JsonProperty("description")
	private String descriptionconfig;
	
	@JsonProperty("messageToken")
	private List<MessageToken> messageToken;

	

	@JsonProperty("severity")
	private String severityconfig;


	@JsonProperty("cause")
	private String causeconfig;


	@JsonProperty("subCause")
	private String subCause;


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
