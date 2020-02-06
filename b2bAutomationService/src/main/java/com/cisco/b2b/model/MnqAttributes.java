package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MnqAttributes {
	
	@JsonProperty("channelProgram")
	private String channelProgram;
	
	@JsonProperty("mnqDestEligFlag")
	private String mnqDestEligFlag;

	public String getChannelProgram() {
		return channelProgram;
	}

	public void setChannelProgram(String channelProgram) {
		this.channelProgram = channelProgram;
	}

	public String getMnqDestEligFlag() {
		return mnqDestEligFlag;
	}

	public void setMnqDestEligFlag(String mnqDestEligFlag) {
		this.mnqDestEligFlag = mnqDestEligFlag;
	}
	
	

}
