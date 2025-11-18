package com.leigh4java.contfound4java.designMode.mediatorPattern.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 具体中介者 - 聊天室
public class ChatRoom implements ChatMediator {
    private List<User> users;
    private String roomName;

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        this.users = new ArrayList<>();
        System.out.println("聊天室 '" + roomName + "' 已创建");
    }

    @Override
    public void sendMessage(String message, User user) {
        System.out.println("【" + roomName + "】" + user.getName() + " 发送消息: " + message);

        // 向所有其他用户发送消息
        for (User u : users) {
            if (u != user) {
                u.receive(message, user);
            }
        }

        // 记录聊天历史
        logMessage(user.getName(), message);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
        System.out.println("用户 " + user.getName() + " 加入了聊天室 '" + roomName + "'");

        // 通知其他用户有新用户加入
        for (User u : users) {
            if (u != user) {
                u.receive(user.getName() + " 加入了聊天室", null);
            }
        }
    }

    @Override
    public void removeUser(User user) {
        if (users.remove(user)) {
            System.out.println("用户 " + user.getName() + " 离开了聊天室 '" + roomName + "'");

            // 通知其他用户有用户离开
            for (User u : users) {
                u.receive(user.getName() + " 离开了聊天室", null);
            }
        }
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public String getRoomName() {
        return roomName;
    }

    private void logMessage(String username, String message) {
        // 在实际应用中，这里会将消息记录到数据库或文件
        System.out.println("【日志】" + new Date() + " - " + username + ": " + message);
    }

    // 获取在线用户列表
    public void showOnlineUsers() {
        System.out.println("=== 在线用户列表 (" + roomName + ") ===");
        for (User user : users) {
            System.out.println("- " + user.getName() +
                    (user.isOnline() ? " (在线)" : " (离线)"));
        }
    }
}
