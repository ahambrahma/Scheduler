package com.scheduler;

import com.scheduler.models.*;
import com.scheduler.service.QueueService;
import com.scheduler.service.WorkerService;
import com.scheduler.contracts.Job;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Job job1 = new FixedTimeJob("first job", System.currentTimeMillis() + 3000);
        Job job2 = new ScheduledTimeJob("second job", System.currentTimeMillis() + 3000, 5000L);
        Job job3 = new ScheduledPostCompletionJob("third job", System.currentTimeMillis() + 3000, 2000L);

        JobQueue queue = new JobQueue();

        WorkerService workerService = new WorkerService();
        QueueService queueService = new QueueService(queue, workerService);

        Worker worker1 = new Worker(queue);
        Worker worker2 = new Worker(queue);
        Worker worker3 = new Worker(queue);

        workerService.addWorker(worker1);
        workerService.addWorker(worker2);
        workerService.addWorker(worker3);

        queueService.addJob(job1);
        queueService.addJob(job2);
        queueService.addJob(job3);

        Thread.sleep(100000);
    }
}
