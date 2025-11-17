package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 具体命令 - 打开电视
public class TVOnCommand implements Command {
    private TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
        tv.setChannel(1);
        tv.setVolume(20);
    }

    @Override
    public void undo() {
        tv.off();
    }
}
