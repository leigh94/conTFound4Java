package com.leigh4java.contfound4java.designMode.singletonPattern.example;

/**
 * 单例模式 - 双重检查锁单例模式
 */
public class DoubleCheckedLockingSingleton {
    // 使用volatile防止指令重排序
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) { // 第一次检查
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) { // 第二次检查
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("双重检查锁单例模式");
    }
}