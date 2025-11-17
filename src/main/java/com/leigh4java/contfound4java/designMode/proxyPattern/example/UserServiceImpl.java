package com.leigh4java.contfound4java.designMode.proxyPattern.example;

// 真实用户服务
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(String username) {
        System.out.println("添加用户: " + username);
        // 模拟业务操作
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String username) {
        System.out.println("删除用户: " + username);
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getUser(String username) {
        System.out.println("查询用户: " + username);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "用户信息: " + username;
    }

    @Override
    public void updateUser(String username) {
        System.out.println("更新用户: " + username);
        try {
            Thread.sleep(180);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
