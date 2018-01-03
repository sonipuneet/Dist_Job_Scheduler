package com.puneetsoni.djs.master.state.jobs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.atomic.AtomicInteger;

public class Job {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private JobConfig config;
    private JobState state;

    public Job() {
    }

    public Job(@JsonProperty("config") JobConfig config) {
        this(config, new JobState(COUNTER.incrementAndGet(), JobStatus.PENDING));
    }

    @JsonCreator
    public Job(@JsonProperty("config") JobConfig config,
               @JsonProperty("state") JobState state) {
        this.config = config;
        this.state = state;
    }

    @JsonProperty
    public JobConfig getConfig() {
        return config;
    }

    @JsonProperty
    public void setConfig(JobConfig config) {
        this.config = config;
    }

    @JsonProperty
    public JobState getState() {
        return state;
    }

    @JsonProperty
    public void setState(JobState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (!config.equals(job.config)) return false;
        return state.equals(job.state);
    }

    @Override
    public int hashCode() {
        int result = config.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }
}
