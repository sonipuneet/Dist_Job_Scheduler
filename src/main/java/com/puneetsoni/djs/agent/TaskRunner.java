package com.puneetsoni.djs.agent;

import com.puneetsoni.djs.master.state.tasks.Task;
import com.puneetsoni.djs.master.state.tasks.TaskConfig;
import com.puneetsoni.djs.master.state.tasks.TaskStatus;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaskRunner {
    public void runCommand(Task task) {
        TaskConfig config = task.getConfig();
        int taskId = task.getState().getId();
        String s = null;

        try {
            Process p = Runtime.getRuntime().exec(config.getCommand());

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            System.out.println("[STDOUT]");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            System.out.println("[STDERR]");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            System.out.println("EXIT CODE: " + p.exitValue());
            task.getState().setStatus(TaskStatus.FINISHED);

            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error during task execution of taskId: " + taskId);
            e.printStackTrace();
            task.getState().setStatus(TaskStatus.FAILED);
            System.exit(-1);
        }
    }
}
