package com.leigh4java.contfound4java.designMode.prototypePattern.demo;

import java.util.ArrayList;
import java.util.List;

// 深拷贝示例：一个包含引用类型字段的类
class DeepCloneableSheep implements Cloneable {
    private String name;
    private int age;
    private List<String> friends; // 引用类型

    public DeepCloneableSheep(String name, int age, List<String> friends) {
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>(friends); // 新建一个列表，避免外部修改影响
    }

    // 深拷贝
    @Override
    public Object clone() {
        try {
            DeepCloneableSheep cloned = (DeepCloneableSheep) super.clone();
            // 对引用类型字段进行克隆
            cloned.friends = new ArrayList<>(this.friends);
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    // getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getFriends() {
        return new ArrayList<>(friends); // 返回副本，保护内部数据
    }

    public void setFriends(List<String> friends) {
        this.friends = new ArrayList<>(friends);
    }

    @Override
    public String toString() {
        return "DeepCloneableSheep{name='" + name + "', age=" + age + ", friends=" + friends + '}';
    }
}