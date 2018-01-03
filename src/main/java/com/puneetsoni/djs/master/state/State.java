package com.puneetsoni.djs.master.state;

import com.puneetsoni.djs.master.state.agents.Agent;
import com.puneetsoni.djs.master.state.agents.AgentConfig;
import com.puneetsoni.djs.master.state.jobs.Job;
import com.puneetsoni.djs.master.state.jobs.JobConfig;
import com.puneetsoni.djs.master.state.tasks.Task;
import com.puneetsoni.djs.master.state.tasks.TaskConfig;

import java.util.Collection;

public interface State {
    Job addJob(JobConfig jobConfig);

    Job getJob(int id);

    Collection<Job> getJobs();

    Agent addAgent(AgentConfig agentConfig);

    Agent getAgent(String hostname);

    Collection<Agent> getAgents();

    Task addTask(TaskConfig taskConfig);

    Task getTask(int id);

    Collection<Task> getTasks();
}
