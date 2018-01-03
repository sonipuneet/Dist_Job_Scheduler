package com.puneetsoni.djs.agent;

import io.dropwizard.lifecycle.Managed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AgentManager implements Managed {
    private ExecutorService executorService;
    private TaskDispatcher taskDispatcher;
    private HeartBeatBeacon heartBeatBeacon;

    public AgentManager(TaskDispatcher taskDispatcher,
                        HeartBeatBeacon heartBeatBeacon) {
        this.taskDispatcher = taskDispatcher;
        this.heartBeatBeacon = heartBeatBeacon;
    }

    @Override
    public void start() throws Exception {
        executorService = Executors.newFixedThreadPool(2);
        executorService.submit(heartBeatBeacon);
        executorService.submit(taskDispatcher);
    }

    @Override
    public void stop() throws Exception {
        executorService.shutdown();
    }
}
