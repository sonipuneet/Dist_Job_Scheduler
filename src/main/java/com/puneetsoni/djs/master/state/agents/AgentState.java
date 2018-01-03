package com.puneetsoni.djs.master.state.agents;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AgentState {
    private int id;
    private AgentStatus status;

    @JsonCreator
    public AgentState(@JsonProperty("id") int id,
                      @JsonProperty("status") AgentStatus status) {
        this.id = id;
        this.status = status;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty
    public AgentStatus getStatus() {
        return status;
    }

    @JsonProperty
    public void setStatus(AgentStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgentState that = (AgentState) o;

        if (id != that.id) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + status.hashCode();
        return result;
    }
}
