package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

import java.util.NoSuchElementException;

// 具体迭代器 - 链表迭代器
public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> current;
    private Node<T> previous;
    private Node<T> previousPrevious; // 用于支持remove操作
    private boolean canRemove = false;

    public LinkedListIterator(Node<T> head) {
        this.current = head;
        this.previous = null;
        this.previousPrevious = null;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("没有更多元素");
        }
        T data = current.data;
        previousPrevious = previous;
        previous = current;
        current = current.next;
        canRemove = true;
        return data;
    }

    @Override
    public void remove() {
        if (!canRemove) {
            throw new IllegalStateException("在调用next()之前不能调用remove()，或者已经调用过remove()");
        }

        if (previousPrevious == null) {
            // 删除头节点
            // 在实际实现中，需要更新链表的头指针
        } else {
            previousPrevious.next = current;
        }
        previous = previousPrevious;
        canRemove = false;
    }
}

// 链表节点
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}