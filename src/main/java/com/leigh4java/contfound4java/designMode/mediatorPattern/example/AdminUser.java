package com.leigh4java.contfound4java.designMode.mediatorPattern.example;


import java.util.Arrays;
import java.util.List;

// 具体同事类 - 管理员用户
public class AdminUser extends User {
    private List<String> commands;

    public AdminUser(ChatMediator mediator, String name) {
        super(mediator, name);
        this.commands = Arrays.asList("/kick", "/mute", "/ban", "/announce");
    }

    @Override
    public void send(String message) {
        System.out.println("【管理员】" + name + " 正在输入: " + message);

        // 检查是否是命令
        if (isCommand(message)) {
            executeCommand(message);
        } else {
            mediator.sendMessage("[管理员]" + message, this);
        }
    }

    @Override
    public void receive(String message, User sender) {
        String senderName = (sender != null) ? sender.getName() : "系统";
        System.out.println("【管理员通知】" + name + " 收到来自 " + senderName + " 的消息: " + message);
    }

    private boolean isCommand(String message) {
        return commands.stream().anyMatch(message::startsWith);
    }

    private void executeCommand(String command) {
        System.out.println("【系统】管理员 " + name + " 执行命令: " + command);

        // 在实际应用中，这里会实现具体的命令逻辑
        if (command.startsWith("/announce")) {
            String announcement = command.substring("/announce".length()).trim();
            mediator.sendMessage("【公告】" + announcement, this);
        }
    }

    // 管理员特有方法
    public void broadcast(String message) {
        mediator.sendMessage("【广播】" + message, this);
    }
}
