package com.puneetsoni.djs.master.resources;

import com.puneetsoni.djs.master.state.State;
import com.puneetsoni.djs.master.state.jobs.Job;
import com.puneetsoni.djs.master.state.jobs.JobConfig;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/jobs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JobsResource {
    private State state;

    public JobsResource(State state) {
        this.state = state;
    }

    @GET
    public Collection<Job> getJobs() {
        return state.getJobs();
    }

    @GET
    @Path("{id}")
    public Job getJob(@PathParam("id") int jobId) {
        return state.getJob(jobId);
    }

    @POST
    public Job submitJob(JobConfig jobConfig) {
        return state.addJob(jobConfig);
    }
}
