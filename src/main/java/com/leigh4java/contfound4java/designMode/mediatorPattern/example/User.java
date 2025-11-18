package com.leigh4java.contfound4java.designMode.mediatorPattern.example;

// 同事类接口
public abstract class User {
    protected ChatMediator mediator;
    protected String name;
    protected boolean isOnline;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        this.isOnline = true;
        this.mediator.addUser(this);
    }

    // 发送消息
    public abstract void send(String message);

    // 接收消息
    public abstract void receive(String message, User sender);

    // 离开聊天室
    public void leave() {
        this.isOnline = false;
        mediator.removeUser(this);
    }

    // 重新加入
    public void rejoin() {
        this.isOnline = true;
        mediator.addUser(this);
    }

    // getters
    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return isOnline;
    }
}



