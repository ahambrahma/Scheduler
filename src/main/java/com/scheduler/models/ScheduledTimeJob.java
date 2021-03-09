package com.scheduler.models;

import com.scheduler.enums.JobType;
import com.scheduler.contracts.Job;

public class ScheduledTimeJob extends Job {

    public ScheduledTimeJob(final String name, Long executionTime, Long duration) {
        super(name, JobType.SCHEDULED, executionTime, duration);
    }

    @Override
    public void execute() {
        System.out.println("Started execution of the scheduled job at: " + System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed execution of the scheduled job at: " + System.currentTimeMillis());
    }
}
