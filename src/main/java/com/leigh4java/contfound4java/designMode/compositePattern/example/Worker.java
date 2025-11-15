package com.leigh4java.contfound4java.designMode.compositePattern.example;

// 抽象组件（Component）
public interface Worker {
    void add(Worker worker);
    void remove(Worker worker);
    void display(int depth);
}
