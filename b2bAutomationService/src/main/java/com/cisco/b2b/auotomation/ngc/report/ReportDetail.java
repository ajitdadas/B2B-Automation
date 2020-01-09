package com.cisco.b2b.auotomation.ngc.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportDetail {

    /*
     * Report Objects
     */

    private String tcId = null;
    private String bodId = null;
    private boolean result;
    private boolean isExecuted;
    private Date date;
    private String serviceName;
    private String tcName = null;
    private String failureReason = null;
    private String skuName = null;
    private String b2bTagName = null;
    private String b2bTagValue = null;
    private String crossflowTagName = null;
    private String crossflowTagValue = null;
    private String trackName = null;
    private int tcExecuted;
    private int tcPassed;
    private int tcFailed;
    private String tcResult = null;

    /*
     * Lists to hold failed comparison tag & value details
     */
    List<String> tagAndValueLst = new ArrayList<>();
    List<List<String>> failedTagsLst = new ArrayList<>();

    /*
     * Map to store Tag and Value Lists
     */
    Map<String, List<String>> failedSkuDetailsMap = new HashMap<>();

    /*
     * Getters & Setters
     */
    public List<String> getTagAndValueLst() {
        return this.tagAndValueLst;
    }

    public void setTagAndValueLst(final List<String> tagAndValueLst) {
        this.tagAndValueLst = tagAndValueLst;
    }

    public List<List<String>> getFailedTagsLst() {
        return this.failedTagsLst;
    }

    public void setFailedTagsLst(final List<List<String>> failedTagsLst) {
        this.failedTagsLst = failedTagsLst;
    }

    public Map<String, List<String>> getFailedSkuDetailsMap() {
        return this.failedSkuDetailsMap;
    }

    public void setFailedSkuDetailsMap(final Map<String, List<String>> failedSkuDetailsMap) {
        this.failedSkuDetailsMap = failedSkuDetailsMap;
    }

    public String getTcId() {
        return this.tcId;
    }

    public void setTcId(final String tcId) {
        this.tcId = tcId;
    }

    public String getBodId() {
        return this.bodId;
    }

    public void setBodId(final String bodId) {
        this.bodId = bodId;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setResult(final boolean result) {
        this.result = result;
    }

    public boolean isExecuted() {
        return this.isExecuted;
    }

    public void setExecuted(final boolean isExecuted) {
        this.isExecuted = isExecuted;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(final String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTcName() {
        return this.tcName;
    }

    public void setTcName(final String tcName) {
        this.tcName = tcName;
    }

    public String getFailureReason() {
        return this.failureReason;
    }

    public void setFailureReason(final String failureReason) {
        this.failureReason = failureReason;
    }

    public String getSkuName() {
        return this.skuName;
    }

    public void setSkuName(final String skuName) {
        this.skuName = skuName;
    }

    public String getB2bTagName() {
        return this.b2bTagName;
    }

    public void setB2bTagName(final String failedB2BTagNameList) {
        this.b2bTagName = failedB2BTagNameList;
    }

    public String getB2bTagValue() {
        return this.b2bTagValue;
    }

    public void setB2bTagValue(final String b2bTagValue) {
        this.b2bTagValue = b2bTagValue;
    }

    public String getCrossflowTagName() {
        return this.crossflowTagName;
    }

    public void setCrossflowTagName(final String crossflowTagName) {
        this.crossflowTagName = crossflowTagName;
    }

    public String getCrossflowTagValue() {
        return this.crossflowTagValue;
    }

    public void setCrossflowTagValue(final String crossflowTagValue) {
        this.crossflowTagValue = crossflowTagValue;
    }

    public String getTrackName() {
        return this.trackName;
    }

    public void setTrackName(final String trackName) {
        this.trackName = trackName;
    }

    public int getTcExecuted() {
        return this.tcExecuted;
    }

    public void setTcExecuted(final int tcExecuted) {
        this.tcExecuted = tcExecuted;
    }

    public int getTcPassed() {
        return this.tcPassed;
    }

    public void setTcPassed(final int tcPassed) {
        this.tcPassed = tcPassed;
    }

    public int getTcFailed() {
        return this.tcFailed;
    }

    public void setTcFailed(final int tcFailed) {
        this.tcFailed = tcFailed;
    }

	public String getTcResult() {
		return tcResult;
	}

	public void setTcResult(String tcResult) {
		this.tcResult = tcResult;
	}
}
