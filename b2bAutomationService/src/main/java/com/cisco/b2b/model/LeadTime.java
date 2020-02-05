
package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LeadTime {

	@JsonProperty("Duration")
	private String duration;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "LeadTime [duration=" + duration + "]";
	}

}
