package com.puneetsoni.djs.master.resources;

import com.puneetsoni.djs.master.state.State;
import com.puneetsoni.djs.master.state.tasks.Task;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TasksResource {
    private State state;

    public TasksResource(State state) {
        this.state = state;
    }

    @GET
    public Collection<Task> getTasks() {
        return state.getTasks();
    }

    @GET
    @Path("{id}")
    public Task getTask(@PathParam("id") Integer taskId) {
        // TODO: Error handling
        return state.getTask(taskId);
    }
}
