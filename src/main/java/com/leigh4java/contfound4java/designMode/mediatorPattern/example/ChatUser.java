package com.leigh4java.contfound4java.designMode.mediatorPattern.example;

// 具体同事类 - 普通用户
public class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(name + " 正在输入: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message, User sender) {
        String senderName = (sender != null) ? sender.getName() : "系统";
        System.out.println(name + " 收到来自 " + senderName + " 的消息: " + message);
    }
}