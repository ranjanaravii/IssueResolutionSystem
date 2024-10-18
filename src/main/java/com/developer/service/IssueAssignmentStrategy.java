package com.developer.service;

import com.developer.entity.Agent;
import com.developer.entity.Issue;

import java.util.List;

public interface IssueAssignmentStrategy {
    void assignIssue(Issue issue, List<Agent> agents);

    void assignIssue(Issue issue, List<Agent> agents, List<Agent> waitlist);

}
