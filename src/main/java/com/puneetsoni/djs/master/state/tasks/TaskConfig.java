package com.puneetsoni.djs.master.state.tasks;

public class TaskConfig {
    private String command;

    public TaskConfig(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
