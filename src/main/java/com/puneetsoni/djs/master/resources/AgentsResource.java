package com.puneetsoni.djs.master.resources;

import com.puneetsoni.djs.master.state.State;
import com.puneetsoni.djs.master.state.agents.Agent;
import com.puneetsoni.djs.master.state.agents.AgentConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/agents")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgentsResource {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private State state;

    public AgentsResource(State state) {
        this.state = state;
    }

    @GET
    public Collection<Agent> getAgents() {
        return state.getAgents();
    }

    @POST
    public Agent registerAgent(AgentConfig agentConfig) {
        LOGGER.info("Received agent register request: ", agentConfig);
        return state.addAgent(agentConfig);
    }
}
