package com.puneetsoni.djs.master.state.jobs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class JobState {
    private int id;
    private JobStatus status;
    private Set<Integer> tasks;

    @JsonCreator
    public JobState(@JsonProperty("id") int id,
                    @JsonProperty("status") JobStatus status) {
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
    public JobStatus getStatus() {
        return status;
    }

    @JsonProperty
    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public void addTask(int taskId) {
        tasks.add(taskId);
    }
}
