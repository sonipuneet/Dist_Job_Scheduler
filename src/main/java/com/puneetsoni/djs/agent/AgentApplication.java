package com.puneetsoni.djs.agent;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;

public class AgentApplication extends Application<AgentConfiguration> {
    @Override
    public String getName() {
        return "agent";
    }

    @Override
    public void run(AgentConfiguration configuration, Environment environment) throws Exception {
        final Client client = new JerseyClientBuilder(environment)
                .using(configuration.getJerseyClient())
                .build(getName());
        TaskDispatcher taskDispatcher = new TaskDispatcher();
        HeartBeatBeacon heartBeatBeacon = new HeartBeatBeacon(configuration, client);
        AgentManager agentManager = new AgentManager(taskDispatcher, heartBeatBeacon);
        environment.lifecycle().manage(agentManager);
    }
}
