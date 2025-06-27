package com.platzi.jobsearch;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class JobPosition {
    @SerializedName("job_id")
    private String jobId;

    @SerializedName("job_title")
    private String jobTitle;

    @SerializedName("employer_name")
    private String employerName;

    @SerializedName("employer_website")
    private String employerWebsite;

    @SerializedName("job_employment_type")
    private String jobEmploymentType;

    @SerializedName("job_apply_link")
    private String jobApplyLink;

    @SerializedName("job_location")
    private String jobLocation;

    @SerializedName("job_country")
    private String jobCountry;

    @SerializedName("job_posted_at_timestamp")
    private String jobPostedAtTimestamp;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerWebsite() {
        return employerWebsite;
    }

    public void setEmployerWebsite(String employerWebsite) {
        this.employerWebsite = employerWebsite;
    }

    public String getJobEmploymentType() {
        return jobEmploymentType;
    }

    public void setJobEmploymentType(String jobEmploymentType) {
        this.jobEmploymentType = jobEmploymentType;
    }

    public String getJobApplyLink() {
        return jobApplyLink;
    }

    public void setJobApplyLink(String jobApplyLink) {
        this.jobApplyLink = jobApplyLink;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobCountry() {
        return jobCountry;
    }

    public void setJobCountry(String jobCountry) {
        this.jobCountry = jobCountry;
    }

    public String getJobPostedAtTimestamp() {
        return jobPostedAtTimestamp;
    }

    public void setJobPostedAtTimestamp(String jobPostedAtTimestamp) {
        this.jobPostedAtTimestamp = jobPostedAtTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JobPosition that = (JobPosition) o;
        return Objects.equals(jobId, that.jobId) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(employerName, that.employerName) && Objects.equals(employerWebsite, that.employerWebsite) && Objects.equals(jobEmploymentType, that.jobEmploymentType) && Objects.equals(jobApplyLink, that.jobApplyLink) && Objects.equals(jobLocation, that.jobLocation) && Objects.equals(jobCountry, that.jobCountry) && Objects.equals(jobPostedAtTimestamp, that.jobPostedAtTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobTitle, employerName, employerWebsite, jobEmploymentType, jobApplyLink, jobLocation, jobCountry, jobPostedAtTimestamp);
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "jobId='" + jobId + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", employerName='" + employerName + '\'' +
                ", employerWebsite='" + employerWebsite + '\'' +
                ", jobEmploymentType='" + jobEmploymentType + '\'' +
                ", jobApplyLink='" + jobApplyLink + '\'' +
                ", jobLocation='" + jobLocation + '\'' +
                ", jobCountry='" + jobCountry + '\'' +
                ", jobPostedAtTimestamp='" + jobPostedAtTimestamp + '\'' +
                ", status = " + status +
                '}';
    }
}
