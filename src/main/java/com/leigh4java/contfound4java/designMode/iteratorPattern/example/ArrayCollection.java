package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

// 数组集合
public class ArrayCollection<T> implements Aggregate<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayCollection() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void add(T item) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = item;
    }

    @Override
    public Iterator<T> createIterator() {
        return new ArrayIterator<>(elements, size);
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界: " + index);
        }
        return elements[index];
    }
}
