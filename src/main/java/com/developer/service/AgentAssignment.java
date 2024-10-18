package com.developer.service;

import com.developer.entity.Agent;
import com.developer.entity.Issue;

import java.util.List;

public class AgentAssignment implements IssueAssignmentStrategy {

    @Override
    public void assignIssue(Issue issue, List<Agent> agents) {
        for (Agent agent : agents) {
            if (agent.isExpertIn(issue.getIssueType()) && agent.isAvailable()) {
                agent.assignIssue(issue);
                System.out.println("Issue " + issue.getIssueId() + " assigned to agent " + agent.getAgentName());
                return;
            }
        }
        System.out.println("No agent available to assign issue " + issue.getIssueId() + " adding to waitlist");
    }

    @Override
    public void assignIssue(Issue issue, List<Agent> agents, List<Agent> waitlist) {
        for (Agent agent : agents) {
            if (agent.isExpertIn(issue.getIssueType()) && agent.isAvailable()) {
                agent.assignIssue(issue);
                System.out.println("Issue " + issue.getIssueId() + " assigned to agent " + agent.getAgentName());
                return;
            }
        }
        waitlist.add(agents.get(0));
        System.out.println("No agent available to assign issue " + issue.getIssueId() + " adding to waitlist");
    }
}
