package com.cisco.b2b.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "LifeCyclePhase",
    "RecommendedServiceType",
    "BusinessService",
    "Architecture",
    "Deliverables",
    "Timelines",
    "Rank"
})
public class ConfigurationRecommendationAttributes {

    @JsonProperty("LifeCyclePhase")
    private String lifeCyclePhase;
    @JsonProperty("RecommendedServiceType")
    private String recommendedServiceType;
    @JsonProperty("BusinessService")
    private String businessService;
    @JsonProperty("Architecture")
    private String architecture;
    @JsonProperty("Deliverables")
    private String deliverables;
    @JsonProperty("Timelines")
    private String timelines;
    @JsonProperty("Rank")
    private String rank;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("LifeCyclePhase")
    public String getLifeCyclePhase() {
        return lifeCyclePhase;
    }

    @JsonProperty("LifeCyclePhase")
    public void setLifeCyclePhase(String lifeCyclePhase) {
        this.lifeCyclePhase = lifeCyclePhase;
    }

    public ConfigurationRecommendationAttributes withLifeCyclePhase(String lifeCyclePhase) {
        this.lifeCyclePhase = lifeCyclePhase;
        return this;
    }

    @JsonProperty("RecommendedServiceType")
    public String getRecommendedServiceType() {
        return recommendedServiceType;
    }

    @JsonProperty("RecommendedServiceType")
    public void setRecommendedServiceType(String recommendedServiceType) {
        this.recommendedServiceType = recommendedServiceType;
    }

    public ConfigurationRecommendationAttributes withRecommendedServiceType(String recommendedServiceType) {
        this.recommendedServiceType = recommendedServiceType;
        return this;
    }

    @JsonProperty("BusinessService")
    public String getBusinessService() {
        return businessService;
    }

    @JsonProperty("BusinessService")
    public void setBusinessService(String businessService) {
        this.businessService = businessService;
    }

    public ConfigurationRecommendationAttributes withBusinessService(String businessService) {
        this.businessService = businessService;
        return this;
    }

    @JsonProperty("Architecture")
    public String getArchitecture() {
        return architecture;
    }

    @JsonProperty("Architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public ConfigurationRecommendationAttributes withArchitecture(String architecture) {
        this.architecture = architecture;
        return this;
    }

    @JsonProperty("Deliverables")
    public String getDeliverables() {
        return deliverables;
    }

    @JsonProperty("Deliverables")
    public void setDeliverables(String deliverables) {
        this.deliverables = deliverables;
    }

    public ConfigurationRecommendationAttributes withDeliverables(String deliverables) {
        this.deliverables = deliverables;
        return this;
    }

    @JsonProperty("Timelines")
    public String getTimelines() {
        return timelines;
    }

    @JsonProperty("Timelines")
    public void setTimelines(String timelines) {
        this.timelines = timelines;
    }

    public ConfigurationRecommendationAttributes withTimelines(String timelines) {
        this.timelines = timelines;
        return this;
    }

    @JsonProperty("Rank")
    public String getRank() {
        return rank;
    }

    @JsonProperty("Rank")
    public void setRank(String rank) {
        this.rank = rank;
    }

    public ConfigurationRecommendationAttributes withRank(String rank) {
        this.rank = rank;
        return this;
    }

    @Override
	public String toString() {
		return "ConfigurationRecommendationAttributes [lifeCyclePhase=" + lifeCyclePhase + ", recommendedServiceType="
				+ recommendedServiceType + ", businessService=" + businessService + ", architecture=" + architecture
				+ ", deliverables=" + deliverables + ", timelines=" + timelines + ", rank=" + rank
				+ ", additionalProperties=" + additionalProperties + "]";
	}

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public ConfigurationRecommendationAttributes withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lifeCyclePhase).append(recommendedServiceType).append(businessService).append(architecture).append(deliverables).append(timelines).append(rank).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ConfigurationRecommendationAttributes) == false) {
            return false;
        }
        ConfigurationRecommendationAttributes rhs = ((ConfigurationRecommendationAttributes) other);
        return new EqualsBuilder().append(lifeCyclePhase, rhs.lifeCyclePhase).append(recommendedServiceType, rhs.recommendedServiceType).append(businessService, rhs.businessService).append(architecture, rhs.architecture).append(deliverables, rhs.deliverables).append(timelines, rhs.timelines).append(rank, rhs.rank).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
