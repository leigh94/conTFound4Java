package com.leigh4java.contfound4java.designMode.singletonPattern.first;

public class SingletonDemo {
    public static void main(String[] args) {
        // 测试饿汉式
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("饿汉式是否同一个实例: " + (eager1 == eager2));
        eager1.showMessage();

        // 测试枚举方式
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        System.out.println("枚举方式是否同一个实例: " + (enum1 == enum2));
        enum1.showMessage();
        enum1.doSomething();

        // 测试多线程环境
        testMultiThread();
    }

    private static void testMultiThread() {
        System.out.println("多线程测试:");
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                DoubleCheckedLockingSingleton instance = DoubleCheckedLockingSingleton.getInstance();
                System.out.println("线程 " + Thread.currentThread().getName() +
                        " 实例哈希码: " + instance.hashCode());
            }).start();
        }
    }
}