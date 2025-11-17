package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 日志命令 - 记录执行日志
public class LoggingCommand implements Command {
    private Command command;
    private String operationName;

    public LoggingCommand(Command command, String operationName) {
        this.command = command;
        this.operationName = operationName;
    }

    @Override
    public void execute() {
        System.out.println("【日志】开始执行: " + operationName);
        long startTime = System.currentTimeMillis();

        command.execute();

        long endTime = System.currentTimeMillis();
        System.out.println("【日志】完成执行: " + operationName +
                ", 耗时: " + (endTime - startTime) + "ms");
    }

    @Override
    public void undo() {
        System.out.println("【日志】撤销: " + operationName);
        command.undo();
    }
}