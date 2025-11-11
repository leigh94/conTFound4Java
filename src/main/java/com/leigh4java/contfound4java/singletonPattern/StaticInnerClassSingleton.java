package com.leigh4java.contfound4java.singletonPattern;

/**
 * 单例模式 - 静态内部类单例模式
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {}

    // 静态内部类在第一次被引用时才会加载
    private static class SingletonHolder {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.instance;
    }

    public void showMessage() {
        System.out.println("静态内部类单例模式");
    }
}