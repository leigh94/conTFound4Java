package com.leigh4java.contfound4java.designMode.compositePattern.example;

import java.util.ArrayList;
import java.util.List;

// 容器（Composite）
public class Manager implements Worker {
    private String name;
    private List<Worker> workers = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public void add(Worker worker) {
        workers.add(worker);
    }

    @Override
    public void remove(Worker worker) {
        workers.remove(worker);
    }

    @Override
    public void display(int depth) {
        System.out.println("-".repeat(depth) + name);
        for (Worker worker : workers) {
            worker.display(depth + 2);
        }
    }
}

