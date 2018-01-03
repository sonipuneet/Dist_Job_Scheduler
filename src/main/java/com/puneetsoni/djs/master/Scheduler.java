package com.puneetsoni.djs.master;

import com.puneetsoni.djs.master.state.State;

import java.util.concurrent.atomic.AtomicInteger;

public class Scheduler implements Runnable {
    private AtomicInteger count = new AtomicInteger();
    private State state;

    public Scheduler(State state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (true) {
            count.addAndGet(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return count.get();
    }
}
