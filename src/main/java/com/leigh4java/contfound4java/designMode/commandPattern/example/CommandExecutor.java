package com.leigh4java.contfound4java.designMode.commandPattern.example;

import java.util.concurrent.*;
import java.util.*;

// 命令队列执行器
public class CommandExecutor {
    private BlockingQueue<Command> commandQueue;
    private ExecutorService executor;
    private volatile boolean isRunning;
    private Stack<Command> historyStack;
    private Stack<Command> redoStack;

    public CommandExecutor() {
        this.commandQueue = new LinkedBlockingQueue<>();
        this.executor = Executors.newSingleThreadExecutor();
        this.historyStack = new Stack<>();
        this.redoStack = new Stack<>();
        this.isRunning = true;

        // 启动命令处理线程
        executor.execute(this::processCommands);
    }

    // 提交命令到队列
    public void submitCommand(Command command) {
        try {
            commandQueue.put(command);
            redoStack.clear(); // 新命令清空重做栈
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 处理命令队列
    private void processCommands() {
        while (isRunning || !commandQueue.isEmpty()) {
            try {
                Command command = commandQueue.take();
                System.out.println("【执行器】执行命令: " + command.getClass().getSimpleName());
                command.execute();
                historyStack.push(command);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    // 撤销上一个命令
    public void undo() {
        if (!historyStack.isEmpty()) {
            Command command = historyStack.pop();
            System.out.println("【执行器】撤销命令: " + command.getClass().getSimpleName());
            command.undo();
            redoStack.push(command);
        }
    }

    // 重做命令
    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            System.out.println("【执行器】重做命令: " + command.getClass().getSimpleName());
            command.execute();
            historyStack.push(command);
        }
    }

    // 关闭执行器
    public void shutdown() {
        isRunning = false;
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    // 批量提交命令
    public void submitCommands(List<Command> commands) {
        for (Command command : commands) {
            submitCommand(command);
        }
    }

    // 获取队列大小
    public int getQueueSize() {
        return commandQueue.size();
    }
}
