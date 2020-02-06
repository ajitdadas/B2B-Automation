package com.cisco.b2b.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceAttributes {
	@JsonProperty("UserSpecifiedStartDate")
	private String userSpecifiedStartDate;
	
	@JsonProperty("ServiceLevelName")
	private String serviceLevelName;
	
	@JsonProperty("ServicLevelDescription")
	private String servicLevelDescription;
	
	@JsonProperty("Duration")
	private String duration;
	
	@JsonProperty("ServiceType")
	private String serviceType;
	
	@JsonProperty("serviceType")
	private String serviceTypeconfig;

	public String getUserSpecifiedStartDate() {
		return userSpecifiedStartDate;
	}

	public void setUserSpecifiedStartDate(String userSpecifiedStartDate) {
		this.userSpecifiedStartDate = userSpecifiedStartDate;
	}

	public String getServiceLevelName() {
		return serviceLevelName;
	}

	public void setServiceLevelName(String serviceLevelName) {
		this.serviceLevelName = serviceLevelName;
	}

	public String getServicLevelDescription() {
		return servicLevelDescription;
	}

	public void setServicLevelDescription(String servicLevelDescription) {
		this.servicLevelDescription = servicLevelDescription;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceTypeconfig() {
		return serviceTypeconfig;
	}

	public void setServiceTypeconfig(String serviceTypeconfig) {
		this.serviceTypeconfig = serviceTypeconfig;
	}
	
	
	
	
}
