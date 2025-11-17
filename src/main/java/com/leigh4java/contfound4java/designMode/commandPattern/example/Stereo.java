package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 音响类
public class Stereo {
    private String location;
    private int volume;
    private boolean isOn = false;

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        isOn = true;
        System.out.println(location + " 音响打开");
    }

    public void off() {
        isOn = false;
        System.out.println(location + " 音响关闭");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(location + " 音响音量设置为 " + volume);
    }

    public void setCD() {
        System.out.println(location + " 音响设置为CD模式");
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOn() {
        return isOn;
    }
}
