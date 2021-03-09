package com.scheduler.models;

import com.scheduler.enums.JobType;
import com.scheduler.contracts.Job;


public class Worker implements Runnable {
    private Job job;
    private JobQueue queue;
    private final Object object = new Object();

    public Worker(JobQueue queue) {
        this.queue = queue;
    }

    public synchronized void setJob(Job job) {
        this.job = job;
    }

    public synchronized Job getJob() {
        return this.job;
    }

    @Override
    public void run() {

        try {
            synchronized (object) {
                do {
                    Job job = getJob();
                    while (job == null) {
                        object.wait();
                        job = getJob();
                    }

                    if (JobType.SCHEDULED.equals(job.getType())) {
                        queue.addJob(new ScheduledTimeJob(job.getName(), System.currentTimeMillis() + job.getDuration(), job.getDuration()));
                    }

                    job.execute();

                    if (JobType.SCHEDULED_POST_COMPLETION.equals(job.getType())) {
                        queue.addJob(new ScheduledPostCompletionJob(job.getName(), System.currentTimeMillis() + job.getDuration(), job.getDuration()));
                    }

                    setJob(null);
                } while (true);
            }

        } catch (InterruptedException e){
        }


    }

    public void wakeUp() {
        synchronized (object) {
            object.notify();
        }
    }
}
