package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

import java.util.NoSuchElementException;

// 具体迭代器 - 数组迭代器
public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int position;
    private int size;

    public ArrayIterator(T[] array, int size) {
        this.array = array;
        this.size = size;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("没有更多元素");
        }
        return array[position++];
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("在调用next()之前不能调用remove()");
        }
        // 将后面的元素前移
        for (int i = position - 1; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        position--;
    }
}
