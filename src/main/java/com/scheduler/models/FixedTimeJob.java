package com.scheduler.models;

import com.scheduler.enums.JobType;
import com.scheduler.contracts.Job;

public class FixedTimeJob extends Job {

    public FixedTimeJob(final String name, Long executionTime) {
        super(name, JobType.FIXED, executionTime, null);
    }

    @Override
    public void execute() {
        System.out.println("Started execution of the fixed job at: " + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed execution of the fixed job at: " + System.currentTimeMillis());
    }
}
