package com.puneetsoni.djs.master.state.agents;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.atomic.AtomicInteger;

public class Agent {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private AgentConfig config;
    private AgentState state;

    public Agent() {
    }

    public Agent(@JsonProperty("config") AgentConfig config) {
        this(config, new AgentState(COUNTER.incrementAndGet(), AgentStatus.CONNECTED));
    }

    @JsonCreator
    public Agent(@JsonProperty("config") AgentConfig config,
                 @JsonProperty("state") AgentState state) {
        this.config = config;
        this.state = state;
    }

    @JsonProperty
    public AgentConfig getConfig() {
        return config;
    }

    @JsonProperty
    public void setConfig(AgentConfig config) {
        this.config = config;
    }

    @JsonProperty
    public AgentState getState() {
        return state;
    }

    @JsonProperty
    public void setState(AgentState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agent agent = (Agent) o;

        if (!config.equals(agent.config)) return false;
        return state.equals(agent.state);
    }

    @Override
    public int hashCode() {
        int result = config.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }
}
