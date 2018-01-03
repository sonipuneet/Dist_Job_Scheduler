package com.puneetsoni.djs.master.state;

import com.puneetsoni.djs.master.state.agents.Agent;
import com.puneetsoni.djs.master.state.agents.AgentConfig;
import com.puneetsoni.djs.master.state.jobs.Job;
import com.puneetsoni.djs.master.state.jobs.JobConfig;
import com.puneetsoni.djs.master.state.tasks.Task;
import com.puneetsoni.djs.master.state.tasks.TaskConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryState implements State {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * Hostname -> Agent
     */
    private Map<String, Agent> agents = new HashMap<>();

    /**
     * jobId -> Job
     */
    private Map<Integer, Job> jobs = new HashMap<>();

    /**
     * taskId -> Task
     */
    private Map<Integer, Task> tasks = new HashMap<>();

    public Job addJob(JobConfig jobConfig) {
        Job job = new Job(jobConfig);
        jobs.put(job.getState().getId(), job);
        for (int i = 0; i < jobConfig.getReplicas(); i++) {
            TaskConfig taskConfig = new TaskConfig(jobConfig.getCommand());
            Task task = new Task(taskConfig);
            int taskId = task.getState().getId();
            tasks.put(taskId, task);
            job.getState().addTask(taskId);
        }
        return job;
    }

    public Job getJob(int id) {
        return jobs.get(id);
    }

    @Override
    public Collection<Job> getJobs() {
        return jobs.values();
    }

    public Agent addAgent(AgentConfig agentConfig) {
        if (agents.containsKey(agentConfig.getHostname())) {
            return getAgent(agentConfig.getHostname());
        }
        Agent agent = new Agent(agentConfig);
        LOGGER.info("Registering Agent: ", agent);
        agents.put(agentConfig.getHostname(), agent);
        return agent;
    }

    public Agent getAgent(String hostname) {
        return agents.get(hostname);
    }

    public Collection<Agent> getAgents() {
        return agents.values();
    }

    public Task addTask(TaskConfig taskConfig) {
        Task task = new Task(taskConfig);
        tasks.put(task.getState().getId(), task);
        return task;
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public Collection<Task> getTasks() {
        return tasks.values();
    }
}
