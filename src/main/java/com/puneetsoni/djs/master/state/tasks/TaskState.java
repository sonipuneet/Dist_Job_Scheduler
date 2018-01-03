package com.puneetsoni.djs.master.state.tasks;

public class TaskState {
    private int id;
    private TaskStatus status;

    public TaskState(int id, TaskStatus status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskState taskState = (TaskState) o;

        if (id != taskState.id) return false;
        return status == taskState.status;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + status.hashCode();
        return result;
    }
}
