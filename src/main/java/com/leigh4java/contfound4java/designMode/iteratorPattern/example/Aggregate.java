package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

// 聚合接口
public interface Aggregate<T> {
    Iterator<T> createIterator();
    void add(T item);
    int size();
}
