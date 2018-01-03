package com.puneetsoni.djs.master.state.agents;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = AgentConfig.class)
public class AgentConfig {
    private String hostname;

    public AgentConfig() {
        this.hostname = "";
    }

    @JsonCreator
    public AgentConfig(@JsonProperty String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty
    public String getHostname() {
        return hostname;
    }

    @JsonProperty
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
