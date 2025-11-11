package com.leigh4java.contfound4java.singletonPattern;

/**
 * 单例模式 - 线程安全的懒汉式
 */
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    // 方法同步，性能较低
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("线程安全的懒汉式单例模式");
    }
}