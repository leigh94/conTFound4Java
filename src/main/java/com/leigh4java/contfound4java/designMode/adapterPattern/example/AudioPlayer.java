package com.leigh4java.contfound4java.designMode.adapterPattern.example;

// 4. 客户端类 - 使用目标接口
public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    public AudioPlayer() {
        this.mediaAdapter = new MediaAdapter();
    }

    @Override
    public void play(String audioType, String fileName) {
        // 内置支持MP3格式
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        }
        // 使用适配器支持其他格式
        else if(audioType.equalsIgnoreCase("vlc") ||
                audioType.equalsIgnoreCase("mp4") ||
                audioType.equalsIgnoreCase("avi")) {
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Unsupported format: " + audioType);
        }
    }
}