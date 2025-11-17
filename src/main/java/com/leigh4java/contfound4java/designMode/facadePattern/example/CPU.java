package com.leigh4java.contfound4java.designMode.facadePattern.example;

// 子系统类 - CPU
public class CPU {
    public void start() {
        System.out.println("CPU 启动中...");
    }

    public void execute() {
        System.out.println("CPU 执行指令...");
    }

    public void shutdown() {
        System.out.println("CPU 关闭中...");
    }
}
