package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

import java.util.NoSuchElementException;

// 过滤迭代器
public class FilterIterator<T> implements Iterator<T> {
    private Iterator<T> iterator;
    private Predicate<T> predicate;
    private T nextElement;
    private boolean hasNextElement;

    public FilterIterator(Iterator<T> iterator, Predicate<T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        findNext();
    }

    @Override
    public boolean hasNext() {
        return hasNextElement;
    }

    @Override
    public T next() {
        if (!hasNextElement) {
            throw new NoSuchElementException("没有更多元素");
        }
        T result = nextElement;
        findNext();
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("过滤迭代器不支持remove操作");
    }

    private void findNext() {
        hasNextElement = false;
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (predicate.test(element)) {
                nextElement = element;
                hasNextElement = true;
                break;
            }
        }
    }

    // 谓词接口
    public interface Predicate<T> {
        boolean test(T item);
    }
}
