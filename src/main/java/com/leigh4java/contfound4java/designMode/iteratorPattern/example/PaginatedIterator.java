package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// 分页迭代器
public class PaginatedIterator<T> implements Iterator<List<T>> {
    private Iterator<T> iterator;
    private int pageSize;

    public PaginatedIterator(Iterator<T> iterator, int pageSize) {
        this.iterator = iterator;
        this.pageSize = pageSize;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public List<T> next() {
        if (!hasNext()) {
            throw new NoSuchElementException("没有更多元素");
        }

        List<T> page = new ArrayList<>();
        int count = 0;
        while (iterator.hasNext() && count < pageSize) {
            page.add(iterator.next());
            count++;
        }
        return page;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("分页迭代器不支持remove操作");
    }
}
