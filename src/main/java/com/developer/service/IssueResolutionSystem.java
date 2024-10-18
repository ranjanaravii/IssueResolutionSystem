package com.developer.service;

import com.developer.entity.Agent;
import com.developer.entity.Issue;
import com.developer.entity.IssueStatus;
import com.developer.entity.IssueType;
import com.developer.exception.AgentCannotHandleIssueException;
import com.developer.exception.InvalidIssueTypeException;

import java.util.ArrayList;
import java.util.List;

public class IssueResolutionSystem {

    private static IssueResolutionSystem instance;
    private List<Issue> issues = new ArrayList<>();
    private List<Agent> agents = new ArrayList<>();
    private IssueAssignmentStrategy issueAssignmentStrategy = new AgentAssignment();

    private IssueResolutionSystem() {
    }

    public static IssueResolutionSystem getInstance() {
        if (instance == null) {
            instance = new IssueResolutionSystem();
        }
        return instance;
    }

    public void createIssue(String transactionId, IssueType issueType, String subject, String issueDescription, String email) {
        try{
            Issue issue = IssueFactory.createIssue(transactionId, issueType, subject, issueDescription, email);
            issues.add(issue);
            System.out.println("Issue " + issue.getIssueId() + " created against transaction " + transactionId);
            assignIssue(issue.getIssueId());
        } catch (InvalidIssueTypeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addAgent(String agentName, String agentEmail, List<IssueType> expertise) {
        Agent agent = AgentFactory.createAgent(agentName, agentEmail, expertise);
        agents.add(agent);
        System.out.println(agent.getAgentName() + " created");
    }

    public void assignIssue(String issueId) {
        try {
            Issue issue = issues.stream().filter(i -> i.getIssueId().equals(issueId)).findFirst().orElse(null);
            if (issue != null) {
                issueAssignmentStrategy.assignIssue(issue, agents);
            }
        } catch (AgentCannotHandleIssueException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateIssue(String issueId, IssueStatus issueStatus, String resolution) {
        Issue issue = issues.stream().filter(i -> i.getIssueId().equals(issueId)).findFirst().orElse(null);
        if (issue != null) {
            issue.setIssueStatus(issueStatus);
            issue.setResolution(resolution);
            System.out.println( issueId + " status updated to " + issueStatus);
        }
    }

    public void resolveIssue(String issueId, String resolution) {
        Issue issue = issues.stream().filter(i -> i.getIssueId().equals(issueId)).findFirst().orElse(null);
        if (issue != null) {
            issue.setIssueStatus(IssueStatus.RESOLVED);
            issue.setResolution(resolution);
            System.out.println(issueId + " issue marked resolved");
        }
    }

    public void viewAgentsWorkHistory() {
        for (Agent agent : agents) {
            System.out.println(agent.getAgentName() + " -> " + agent.getIssuesAssigned());
        }
    }
}
