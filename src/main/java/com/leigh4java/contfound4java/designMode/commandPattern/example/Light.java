package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 电灯类
public class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " 电灯打开");
    }

    public void off() {
        System.out.println(location + " 电灯关闭");
    }
}
