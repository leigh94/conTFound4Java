package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 延迟命令 - 在指定时间后执行
public class DelayedCommand implements Command {
    private Command command;
    private long delayMillis;

    public DelayedCommand(Command command, long delayMillis) {
        this.command = command;
        this.delayMillis = delayMillis;
    }

    @Override
    public void execute() {
        System.out.println("延迟命令: " + delayMillis + "ms 后执行");
        new Thread(() -> {
            try {
                Thread.sleep(delayMillis);
                command.execute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void undo() {
        command.undo();
    }
}
