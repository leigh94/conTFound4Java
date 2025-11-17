package com.leigh4java.contfound4java.designMode.proxyPattern.example;

// 用户服务接口
public interface UserService {
    void addUser(String username);
    void deleteUser(String username);
    String getUser(String username);
    void updateUser(String username);
}

