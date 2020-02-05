
package com.cisco.b2b.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "errorFlag", "requestId", "stats" })
public class ConfigResponse {

	@JsonProperty("majorLine")
	private List<MajorLine> majorLine = new ArrayList<MajorLine>();

	public List<MajorLine> getMajorLine() {
		return majorLine;
	}

	public void setMajorLine(List<MajorLine> majorLine) {
		this.majorLine = majorLine;
	}

}
