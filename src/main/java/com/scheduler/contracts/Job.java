package com.scheduler.contracts;

import com.scheduler.enums.JobType;

import java.util.UUID;

public abstract class Job {

    private final String name;
    private final JobType type;
    private final String id;
    private final Long executionTime;
    private final Long duration;

    public Job(final String name, final JobType type, Long executionTime, Long duration) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.executionTime = executionTime;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public JobType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Long getDuration() {
        return duration;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public abstract void execute();
}
