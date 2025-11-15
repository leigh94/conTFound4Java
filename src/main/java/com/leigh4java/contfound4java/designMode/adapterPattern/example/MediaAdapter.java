package com.leigh4java.contfound4java.designMode.adapterPattern.example;

// 3. 适配器类 - 将不兼容的接口转换为目标接口
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter() {
        this.advancedMediaPlayer = new AdvancedMediaPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        switch(audioType.toLowerCase()) {
            case "vlc":
                advancedMediaPlayer.playVlc(fileName);
                break;
            case "mp4":
                advancedMediaPlayer.playMp4(fileName);
                break;
            case "avi":
                advancedMediaPlayer.playAvi(fileName);
                break;
            default:
                System.out.println("Invalid media type: " + audioType);
        }
    }
}