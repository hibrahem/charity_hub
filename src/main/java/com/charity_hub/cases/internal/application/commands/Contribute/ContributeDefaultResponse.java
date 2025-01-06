package com.charity_hub.cases.internal.application.commands.Contribute;

public class ContributeDefaultResponse  {
    private final String contributionId;

    public ContributeDefaultResponse(String contributionId) {
        
        this.contributionId = contributionId;
    }

    public ContributeDefaultResponse(int id, String description, String contributionId) {
        
        this.contributionId = contributionId;
    }

    public String getContributionId() {
        return contributionId;
    }
}