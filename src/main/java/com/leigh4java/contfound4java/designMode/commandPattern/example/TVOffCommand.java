package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 具体命令 - 关闭电视
public class TVOffCommand implements Command {
    private TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
    }
}
