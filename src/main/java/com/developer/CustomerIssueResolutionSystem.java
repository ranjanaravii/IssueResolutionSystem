package com.developer;

import com.developer.entity.IssueStatus;
import com.developer.entity.IssueType;
import com.developer.service.IssueResolutionSystem;

import java.util.List;

public class CustomerIssueResolutionSystem {
    public static void main(String[] args) {
        System.out.println("Customer Issue Resolution System");


        // Create an instance of IssueResolutionSystem
        IssueResolutionSystem issueResolutionSystem = IssueResolutionSystem.getInstance();

        //add agents in the system
        issueResolutionSystem.addAgent("Agent1", "agent1@gmail.com", List.of(IssueType.PAYMENT_RELATED, IssueType.MUTUAL_FUND_RELATED));
        issueResolutionSystem.addAgent("Agent2", "agaent2@gmail.com", List.of(IssueType.PAYMENT_RELATED));
        issueResolutionSystem.addAgent("Agent3", "agent3@gmail.com", List.of(IssueType.GOLD_RELATED, IssueType.INSURANCE_RELATED));

        // Create an issue
        issueResolutionSystem.createIssue("T1", IssueType.PAYMENT_RELATED, "Payment Failed", "My payment failed but money is debited", "test1@gmail.com");
        issueResolutionSystem.createIssue("T2", IssueType.MUTUAL_FUND_RELATED, "Purchase Failed", "Unable to purchase Mutual Fund", "test2@gmail.com");
        issueResolutionSystem.createIssue("T3", IssueType.PAYMENT_RELATED, "Payment Failed", "My payment failed but money is debited", "test2@gmail.com");

        //assign issue
        issueResolutionSystem.assignIssue("I1");
        issueResolutionSystem.assignIssue("I2");
        issueResolutionSystem.updateIssue("I1", IssueStatus.IN_PROGRESS, "Waiting for Bank confirmation");
        issueResolutionSystem.resolveIssue("I1", "Payment issue resolved, money will be credited in 2 days");

        //view work history of agents
        issueResolutionSystem.viewAgentsWorkHistory();
    }
}