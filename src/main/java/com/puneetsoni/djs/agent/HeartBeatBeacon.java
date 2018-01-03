package com.puneetsoni.djs.agent;

import com.puneetsoni.djs.master.state.agents.Agent;
import com.puneetsoni.djs.master.state.agents.AgentConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class HeartBeatBeacon implements Runnable {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private AgentConfiguration agentConfiguration;
    private Client client;
    public HeartBeatBeacon(AgentConfiguration agentConfiguration,
                           Client client) {
        this.agentConfiguration = agentConfiguration;
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Sending heartbeat");
            String masterHost = agentConfiguration.getMasterHost();
            String masterPort = agentConfiguration.getMasterPort();
            WebTarget target = client.target("http://" + masterHost + ":" + masterPort)
                    .path("agents");
            AgentConfig agentConfig = new AgentConfig("localhost");
            try {
                Agent response = target
                        .request(MediaType.APPLICATION_JSON_TYPE)
                        .accept(MediaType.APPLICATION_JSON_TYPE)
                        .post(Entity.json(agentConfig), Agent.class);
                System.out.println(response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
