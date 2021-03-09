package com.scheduler.service;

import com.scheduler.models.JobQueue;
import com.scheduler.contracts.Job;


public class QueueService {
    private JobQueue queue;
    private WorkerService workerService;

    public QueueService(JobQueue queue, WorkerService workerService) {
        this.queue = queue;
        this.workerService = workerService;
        new Thread(new QueuePollService(workerService, queue)).start();
    }

    public void addJob(Job job) {
        queue.addJob(job);
    }

}
