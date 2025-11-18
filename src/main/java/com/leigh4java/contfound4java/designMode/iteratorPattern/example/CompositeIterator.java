package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

import java.util.NoSuchElementException;
import java.util.Stack;

// 复合迭代器
public class CompositeIterator implements Iterator<Object> {
    private Stack<Iterator<Object>> stack = new Stack<>();

    public CompositeIterator(Iterator<Object> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }

        Iterator<Object> iterator = stack.peek();
        if (!iterator.hasNext()) {
            stack.pop();
            return hasNext();
        }
        return true;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("没有更多元素");
        }

        Iterator<Object> iterator = stack.peek();
        Object component = iterator.next();
        if (component instanceof Aggregate) {
            @SuppressWarnings("unchecked")
            Aggregate<Object> aggregate = (Aggregate<Object>) component;
            stack.push(aggregate.createIterator());
        }
        return component;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("复合迭代器不支持remove操作");
    }
}
