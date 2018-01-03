package com.puneetsoni.djs.master.state.tasks;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    private TaskConfig config;
    private TaskState state;

    public Task(TaskConfig config) {
        this(config, new TaskState(COUNTER.incrementAndGet(), TaskStatus.PENDING));
    }

    public Task(TaskConfig config, TaskState state) {
        this.config = config;
        this.state = state;
    }

    public TaskConfig getConfig() {
        return config;
    }

    public void setConfig(TaskConfig config) {
        this.config = config;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!config.equals(task.config)) return false;
        return state.equals(task.state);
    }

    @Override
    public int hashCode() {
        int result = config.hashCode();
        result = 31 * result + state.hashCode();
        return result;
    }
}
