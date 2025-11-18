package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

// 迭代器接口
public interface Iterator<T> {
    boolean hasNext();
    T next();
    void remove();
}
