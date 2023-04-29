package com.bawp.todoister.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "task_table")

public class Task {
    @ColumnInfo(name = "task_id")
    public long taskId;
    @PrimaryKey(autoGenerate = true)
    public String task;

    public Priority priority;
    @ColumnInfo(name = "due_date")
    public Date dueDate;

    @ColumnInfo(name = "created_at")
    public Date dateCreated;

    public boolean isDone;

    public Task(String task, Priority priority, Date dueDate, Date dateCreated, boolean isDone) {
        this.task = task;
        this.priority = priority;
        this.dueDate = dueDate;
        this.dateCreated = dateCreated;
        this.isDone = isDone;
    }

    public long getTaskId() {
        return taskId;
    }

    public Task setTaskId(long taskId) {
        this.taskId = taskId;
        return this;
    }

    public String getTask() {
        return task;
    }

    public Task setTask(String task) {
        this.task = task;
        return this;
    }

    public Priority getPriority() {
        return priority;
    }

    public Task setPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Task setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Task setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public boolean isDone() {
        return isDone;
    }

    public Task setDone(boolean done) {
        isDone = done;
        return this;
    }
}
