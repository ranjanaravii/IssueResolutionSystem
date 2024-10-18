package com.developer.entity;

public class Issue {
    private static int issueIdCounter = 1;
    private String issueId;
    private String transactionId;
    private IssueType issueType;
    private String subject;
    private String issueDescription;
    private IssueStatus issueStatus;
    private String email;
    private String resolution;

    public Issue(String transactionId, IssueType issueType, String subject, String issueDescription, String email) {
        this.issueId = "I" + issueIdCounter++;
        this.transactionId = transactionId;
        this.issueType = issueType;
        this.subject = subject;
        this.issueDescription = issueDescription;
        this.issueStatus = IssueStatus.OPEN;
        this.email = email;
        this.resolution = "";
    }

    public String getIssueId() {
        return issueId;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId='" + issueId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", issueType=" + issueType +
                ", subject='" + subject + '\'' +
                ", issueDescription='" + issueDescription + '\'' +
                ", issueStatus=" + issueStatus +
                ", email='" + email + '\'' +
                ", resolution='" + resolution + '\'' +
                '}';
    }
}
