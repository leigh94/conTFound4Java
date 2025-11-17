package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 电视类
public class TV {
    private String location;
    private int channel;
    private int volume;
    private boolean isOn = false;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        isOn = true;
        System.out.println(location + " 电视打开");
    }

    public void off() {
        isOn = false;
        System.out.println(location + " 电视关闭");
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println(location + " 电视切换到频道 " + channel);
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(location + " 电视音量设置为 " + volume);
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOn() {
        return isOn;
    }
}
