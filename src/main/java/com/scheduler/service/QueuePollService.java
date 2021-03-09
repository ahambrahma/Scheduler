package com.scheduler.service;

import com.scheduler.models.JobQueue;
import com.scheduler.models.Worker;
import com.scheduler.contracts.Job;

public class QueuePollService implements Runnable {

    private WorkerService workerService;
    private static final Integer QUEUE_POLLING_INTERVAL = 100;
    private JobQueue queue;

    public QueuePollService(WorkerService workerService, JobQueue queue) {
        this.workerService = workerService;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Job job = queue.getLatestJob();

            while (job == null || System.currentTimeMillis() <= job.getExecutionTime()) {
                try {
                    Thread.sleep(QUEUE_POLLING_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                job = queue.getLatestJob();
            }

            queue.removeJob();

            Worker worker = workerService.findWorker();

            if (worker != null) {
                worker.setJob(job);
                worker.wakeUp();
            }

        }
    }
}
