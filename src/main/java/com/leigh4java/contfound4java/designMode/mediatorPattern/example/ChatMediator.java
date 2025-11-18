package com.leigh4java.contfound4java.designMode.mediatorPattern.example;

// 中介者接口
public interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
    void removeUser(User user);
}
