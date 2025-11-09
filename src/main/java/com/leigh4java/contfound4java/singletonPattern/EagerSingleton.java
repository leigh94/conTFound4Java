package com.leigh4java.contfound4java.singletonPattern;

import lombok.Getter;

/**
 * 单例模式 - 饿汉式
 */
public class EagerSingleton {
    // 全局访问点
    // 类加载时就创建实例
    @Getter
    private static final EagerSingleton instance = new EagerSingleton();

    // 私有构造方法
    private EagerSingleton() {
        // 防止通过反射创建实例
        if (instance != null) {
            throw new RuntimeException("单例模式不允许创建多个实例");
        }
    }

    public void showMessage() {
        System.out.println("饿汉式单例模式");
    }
}
