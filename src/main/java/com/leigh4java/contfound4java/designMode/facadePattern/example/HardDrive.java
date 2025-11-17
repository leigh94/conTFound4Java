package com.leigh4java.contfound4java.designMode.facadePattern.example;

// 子系统类 - 硬盘
public class HardDrive {
    public void read() {
        System.out.println("硬盘读取数据...");
    }

    public void write() {
        System.out.println("硬盘写入数据...");
    }
}
