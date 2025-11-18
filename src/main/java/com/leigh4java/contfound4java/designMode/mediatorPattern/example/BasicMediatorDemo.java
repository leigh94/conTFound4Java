package com.leigh4java.contfound4java.designMode.mediatorPattern.example;

public class BasicMediatorDemo {
    public static void main(String[] args) {
        System.out.println("=== 基础中介者模式演示 - 聊天室系统 ===\n");

        // 创建中介者 - 聊天室
        ChatMediator chatRoom = new ChatRoom("Java设计模式讨论群");

        // 创建用户
        User alice = new ChatUser(chatRoom, "Alice");
        User bob = new ChatUser(chatRoom, "Bob");
        User charlie = new ChatUser(chatRoom, "Charlie");
        AdminUser admin = new AdminUser(chatRoom, "Admin");

        System.out.println("\n=== 开始聊天 ===");
        alice.send("大家好，我是Alice，刚学习设计模式");
        bob.send("欢迎Alice！中介者模式很有意思");
        charlie.send("是的，它减少了对象之间的耦合");
        admin.send("/announce 欢迎大家讨论设计模式相关问题");
        admin.send("有问题可以随时问我");

        System.out.println("\n=== 用户离开和重新加入 ===");
        charlie.leave();
        alice.send("Charlie怎么离开了？");
        bob.send("可能临时有事");
        charlie.rejoin();
        charlie.send("我回来了，刚才网络有点问题");

        System.out.println("\n=== 显示在线用户 ===");
        ((ChatRoom) chatRoom).showOnlineUsers();

        System.out.println("\n=== 管理员广播 ===");
        ((AdminUser) admin).broadcast("本群将在今晚进行维护");
    }
}