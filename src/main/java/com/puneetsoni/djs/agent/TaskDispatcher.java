package com.puneetsoni.djs.agent;

import java.util.concurrent.atomic.AtomicInteger;

public class TaskDispatcher implements Runnable {
    private AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            count.addAndGet(1);
            System.out.println(count.get());
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
