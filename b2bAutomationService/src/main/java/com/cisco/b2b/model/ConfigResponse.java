
package com.cisco.b2b.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "errorFlag", "requestId", "metadata","stats" })
public class ConfigResponse {

	@JsonProperty("majorLine")
	private List<MajorLine> majorLine = new ArrayList<MajorLine>();
	
	@JsonProperty("status")
	private String status ;
	
	@JsonProperty("currencyCode")
	private String currencyCode ;
	
	@JsonProperty("ciscoOneLogId")
	private String ciscoOneLogId ;
	
	@JsonProperty("xaasMajorLine")
	private List<XaasMajorLine> xaasMajorLine ;
	
	@JsonProperty("asMajorLine")
	private List<AsMajorLine> asMajorLine ;
	
	@JsonProperty("stats")
	private List<Stats> stats ;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCiscoOneLogId() {
		return ciscoOneLogId;
	}

	public void setCiscoOneLogId(String ciscoOneLogId) {
		this.ciscoOneLogId = ciscoOneLogId;
	}

	public List<MajorLine> getMajorLine() {
		return majorLine;
	}

	public void setMajorLine(List<MajorLine> majorLine) {
		this.majorLine = majorLine;
	}
	
	public List<Stats> getStats() {
		return stats;
	}

	public void setStats(List<Stats> stats) {
		this.stats = stats;
	}

	public List<XaasMajorLine> getXaasMajorLine() {
		return xaasMajorLine;
	}

	public void setXaasMajorLine(List<XaasMajorLine> xaasMajorLine) {
		this.xaasMajorLine = xaasMajorLine;
	}

	public List<AsMajorLine> getAsMajorLine() {
		return asMajorLine;
	}

	public void setAsMajorLine(List<AsMajorLine> asMajorLine) {
		this.asMajorLine = asMajorLine;
	}


}
