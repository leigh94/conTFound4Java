package com.leigh4java.contfound4java.designMode.compositePattern.example;

// 叶子节点（Leaf）
public class Employee implements Worker {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void add(Worker worker) {
        // 叶子没有子节点，不实现
    }

    @Override
    public void remove(Worker worker) {
        // 叶子没有子节点，不实现
    }

    @Override
    public void display(int depth) {
        System.out.println("-".repeat(depth) + name);
    }
}
