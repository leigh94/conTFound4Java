package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

// 反向迭代器
public class ReverseIterator<T> implements Iterator<T> {
    private List<T> list;
    private int position;

    public ReverseIterator(List<T> list) {
        this.list = new ArrayList<>(list);
        Collections.reverse(this.list);
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("没有更多元素");
        }
        return list.get(position++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("反向迭代器不支持remove操作");
    }
}
