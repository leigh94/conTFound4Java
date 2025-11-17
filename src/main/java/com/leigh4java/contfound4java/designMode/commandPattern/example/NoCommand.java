package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 空命令 - 空对象模式
public class NoCommand implements Command {
    @Override
    public void execute() {
        // 什么都不做
    }

    @Override
    public void undo() {
        // 什么都不做
    }
}
