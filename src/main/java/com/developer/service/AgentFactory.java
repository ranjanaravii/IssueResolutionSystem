package com.developer.service;

import com.developer.entity.Agent;
import com.developer.entity.IssueType;

import java.util.List;

public class AgentFactory {
    public static Agent createAgent(String name, String email, List<IssueType> expertise) {
        return new Agent(name, email, expertise);
    }
}
