package com.leigh4java.contfound4java.designMode.singletonPattern.example;

/**
 * 单例模式 - 饿汉式
 */
public class EagerSingleton {
    // 类加载时就创建实例
    private static final EagerSingleton instance = new EagerSingleton();

    // 私有构造方法
    private EagerSingleton() {
        // 防止通过反射创建实例
        if (instance != null) {
            throw new RuntimeException("单例模式不允许创建多个实例");
        }
    }

    // 全局访问点
    public static EagerSingleton getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("饿汉式单例模式");
    }
}