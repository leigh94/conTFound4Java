package com.leigh4java.contfound4java.designMode.adapterPattern.example;

// 5. 测试类
public class AdapterPatternDemo {
    public static void main(String[] args) {
        MediaPlayer audioPlayer = new AudioPlayer();

        // 测试播放不同格式的音频文件
        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("avi", "film.avi");
        audioPlayer.play("wav", "sound.wav"); // 不支持的格式
    }
}
