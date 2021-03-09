package com.scheduler.service;

import com.scheduler.models.Worker;

import java.util.ArrayList;
import java.util.List;

public class WorkerService {

    private List<Worker> workers = new ArrayList<>();

    public synchronized void addWorker(Worker worker) {
        this.workers.add(worker);
        new Thread(worker).start();
    }

    public Worker findWorker() {
        Worker worker = null;
        for (Worker w: workers) {
            if (w.getJob() == null) {
                worker = w;
                break;
            }
        }
        return worker;
    }
}
