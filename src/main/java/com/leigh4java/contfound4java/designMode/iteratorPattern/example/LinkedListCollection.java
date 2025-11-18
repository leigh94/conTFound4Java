package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

// 链表集合
public class LinkedListCollection<T> implements Aggregate<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListCollection() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public Iterator<T> createIterator() {
        return new LinkedListIterator<>(head);
    }

    @Override
    public int size() {
        return size;
    }
}
