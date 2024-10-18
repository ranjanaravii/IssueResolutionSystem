package com.developer.service;

import com.developer.entity.Issue;
import com.developer.entity.IssueType;
import com.developer.exception.InvalidIssueTypeException;

public class IssueFactory {
    public static Issue createIssue(String transactionId, IssueType issueType, String subject, String description, String email) throws InvalidIssueTypeException {
        if (!issueType.equals(IssueType.PAYMENT_RELATED) && !issueType.equals(IssueType.MUTUAL_FUND_RELATED) && !issueType.equals(IssueType.GOLD_RELATED) && !issueType.equals(IssueType.INSURANCE_RELATED)) {
            throw new InvalidIssueTypeException("Invalid issue type");
        }
        return new Issue(transactionId, issueType, subject, description, email);
    }
}
