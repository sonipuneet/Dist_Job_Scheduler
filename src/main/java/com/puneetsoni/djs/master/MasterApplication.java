package com.puneetsoni.djs.master;

import com.puneetsoni.djs.JsonProcessingExceptionMapper;
import com.puneetsoni.djs.master.resources.AgentsResource;
import com.puneetsoni.djs.master.resources.JobsResource;
import com.puneetsoni.djs.master.resources.TasksResource;
import com.puneetsoni.djs.master.state.InMemoryState;
import com.puneetsoni.djs.master.state.State;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MasterApplication extends Application<MasterConfiguration> {
    @Override
    public String getName() {
        return "master";
    }

    @Override
    public void run(MasterConfiguration configuration, Environment environment) throws Exception {
        State state = new InMemoryState();
        Scheduler scheduler = new Scheduler(state);

        final AgentsResource agentsResource = new AgentsResource(state);
        final JobsResource jobsResource = new JobsResource(state);
        final TasksResource tasksResource = new TasksResource(state);
        JsonProcessingExceptionMapper jsonProcessingExceptionMapper = new JsonProcessingExceptionMapper();
        environment.jersey().register(agentsResource);
        environment.jersey().register(jobsResource);
        environment.jersey().register(tasksResource);
        environment.jersey().register(jsonProcessingExceptionMapper);

        MasterManager masterManager = new MasterManager(scheduler);
        environment.lifecycle().manage(masterManager);
    }
}
