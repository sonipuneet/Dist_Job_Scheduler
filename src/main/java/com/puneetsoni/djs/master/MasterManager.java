package com.puneetsoni.djs.master;

import io.dropwizard.lifecycle.Managed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MasterManager implements Managed {
    private Scheduler scheduler;
    private ExecutorService executorService;

    public MasterManager(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public void start() throws Exception {
        executorService = Executors.newSingleThreadExecutor();
        executorService.submit(scheduler);
    }

    @Override
    public void stop() throws Exception {
        executorService.shutdown();
    }
}
