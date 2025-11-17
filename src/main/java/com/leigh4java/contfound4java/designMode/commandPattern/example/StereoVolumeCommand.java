package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 具体命令 - 调节音响音量
public class StereoVolumeCommand implements Command {
    private Stereo stereo;
    private int previousVolume;
    private int newVolume;

    public StereoVolumeCommand(Stereo stereo, int volume) {
        this.stereo = stereo;
        this.newVolume = volume;
    }

    @Override
    public void execute() {
        previousVolume = stereo.getVolume();
        stereo.setVolume(newVolume);
    }

    @Override
    public void undo() {
        stereo.setVolume(previousVolume);
    }
}
