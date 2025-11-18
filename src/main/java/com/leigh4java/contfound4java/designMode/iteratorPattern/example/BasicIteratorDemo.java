package com.leigh4java.contfound4java.designMode.iteratorPattern.example;

import java.util.NoSuchElementException;

public class BasicIteratorDemo {
    public static void main(String[] args) {
        System.out.println("=== 基础迭代器模式演示 ===\n");

        // 测试数组集合
        System.out.println("=== 数组集合测试 ===");
        ArrayCollection<String> arrayCollection = new ArrayCollection<>();
        arrayCollection.add("Apple");
        arrayCollection.add("Banana");
        arrayCollection.add("Orange");
        arrayCollection.add("Grape");

        Iterator<String> arrayIterator = arrayCollection.createIterator();
        while (arrayIterator.hasNext()) {
            System.out.println(arrayIterator.next());
        }

        // 测试链表集合
        System.out.println("\n=== 链表集合测试 ===");
        LinkedListCollection<Integer> linkedListCollection = new LinkedListCollection<>();
        linkedListCollection.add(10);
        linkedListCollection.add(20);
        linkedListCollection.add(30);
        linkedListCollection.add(40);

        Iterator<Integer> linkedListIterator = linkedListCollection.createIterator();
        while (linkedListIterator.hasNext()) {
            System.out.println(linkedListIterator.next());
        }

        // 测试remove操作
        System.out.println("\n=== 测试remove操作 ===");
        ArrayCollection<String> fruits = new ArrayCollection<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grape");

        Iterator<String> fruitIterator = fruits.createIterator();
        while (fruitIterator.hasNext()) {
            String fruit = fruitIterator.next();
            System.out.println("当前水果: " + fruit);
            if (fruit.equals("Banana")) {
                fruitIterator.remove();
                System.out.println("已删除 Banana");
            }
        }

        System.out.println("\n删除后的集合:");
        fruitIterator = fruits.createIterator();
        while (fruitIterator.hasNext()) {
            System.out.println(fruitIterator.next());
        }

        // 测试异常处理
        System.out.println("\n=== 测试异常处理 ===");
        try {
            ArrayCollection<String> emptyCollection = new ArrayCollection<>();
            Iterator<String> emptyIterator = emptyCollection.createIterator();
            emptyIterator.next(); // 应该抛出异常
        } catch (NoSuchElementException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
    }
}