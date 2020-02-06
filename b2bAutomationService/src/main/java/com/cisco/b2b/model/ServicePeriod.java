package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServicePeriod {
	
	@JsonProperty("duration")
	private String duration;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}

