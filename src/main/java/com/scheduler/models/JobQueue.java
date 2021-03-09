package com.scheduler.models;

import com.scheduler.contracts.Job;

import java.util.*;

public class JobQueue {
    private Queue<Job> jobs = new PriorityQueue<>(new JobComparator());

    public synchronized void addJob(Job job) {
        jobs.add(job);
    }

    public synchronized void removeJob() {
        if (!jobs.isEmpty()) {
            jobs.remove();
        }
    }

    public synchronized Job getLatestJob() {
        return jobs.peek();
    }

}

class JobComparator implements Comparator<Job> {
    public int compare(Job j1, Job j2) {
        if (j1.getExecutionTime() < j2.getExecutionTime())
            return 0;
        return 1;
    }
}