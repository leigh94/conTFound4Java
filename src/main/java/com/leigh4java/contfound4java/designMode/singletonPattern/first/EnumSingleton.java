package com.leigh4java.contfound4java.designMode.singletonPattern.first;

/**
 * 单例模式 - 枚举
 */
public enum EnumSingleton {
    INSTANCE;

    public void showMessage() {
        System.out.println("枚举单例模式");
    }

    // 可以添加其他方法
    public void doSomething() {
        System.out.println("执行某些操作...");
    }
}