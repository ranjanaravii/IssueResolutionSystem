package com.developer.entity;

import com.developer.exception.AgentCannotHandleIssueException;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Agent {

    private static int agentIdCounter = 1;
    private String agentId;
    private String agentName;
    private String agentEmail;
    private List<IssueType> expertise;
    private Queue<Issue> issuesAssigned = new LinkedList<>();

    public Agent(String agentName, String agentEmail, List<IssueType> expertise) {
        this.agentId = "A" + agentIdCounter++;
        this.agentName = agentName;
        this.agentEmail = agentEmail;
        this.expertise = expertise;
    }

    public boolean isExpertIn(IssueType issueType) {
        return expertise.contains(issueType);
    }

    public boolean isAvailable() {
        return issuesAssigned.isEmpty();
    }

    public void assignIssue(Issue issue) throws AgentCannotHandleIssueException {
        if (!isExpertIn(issue.getIssueType())) {
            throw new AgentCannotHandleIssueException("Agent " + agentName + " is not expert in " + issue.getIssueType());
        }
        issuesAssigned.add(issue);
    }

    public Issue resolveCurrentIssue() {
        return issuesAssigned.poll();
    }

    public Queue<Issue> getIssuesAssigned() {
        return issuesAssigned;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentId='" + agentId + '\'' +
                ", agentName='" + agentName + '\'' +
                ", agentEmail='" + agentEmail + '\'' +
                ", expertise=" + expertise +
                '}';
    }
}
