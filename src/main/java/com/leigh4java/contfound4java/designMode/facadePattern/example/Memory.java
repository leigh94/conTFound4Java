package com.leigh4java.contfound4java.designMode.facadePattern.example;

// 子系统类 - 内存
public class Memory {
    public void load() {
        System.out.println("内存加载数据...");
    }

    public void free() {
        System.out.println("内存释放...");
    }
}
