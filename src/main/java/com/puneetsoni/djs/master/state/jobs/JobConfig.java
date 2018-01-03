package com.puneetsoni.djs.master.state.jobs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JobConfig {
    private String command;
    private int replicas;

    @JsonCreator
    public JobConfig(@JsonProperty("command") String command,
                     @JsonProperty("replicas") int replicas) {
        this.command = command;
        this.replicas = replicas;
    }

    @JsonProperty
    public String getCommand() {
        return command;
    }

    @JsonProperty
    public void setCommand(String command) {
        this.command = command;
    }

    @JsonProperty
    public int getReplicas() {
        return replicas;
    }

    @JsonProperty
    public void setReplicas(int replicas) {
        this.replicas = replicas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobConfig jobConfig = (JobConfig) o;

        if (replicas != jobConfig.replicas) return false;
        return command.equals(jobConfig.command);
    }

    @Override
    public int hashCode() {
        int result = command.hashCode();
        result = 31 * result + replicas;
        return result;
    }
}
