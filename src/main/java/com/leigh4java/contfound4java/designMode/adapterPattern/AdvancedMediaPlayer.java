package com.leigh4java.contfound4java.designMode.adapterPattern;

// 2. 被适配的类 - 已有的功能但接口不兼容
public class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }

    public void playAvi(String fileName) {
        System.out.println("Playing avi file: " + fileName);
    }
}
