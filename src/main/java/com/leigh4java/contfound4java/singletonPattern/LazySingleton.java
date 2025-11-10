package com.leigh4java.contfound4java.singletonPattern;

/**
 * 单例模式-懒汉式
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("懒汉式单例模式");
    }
}