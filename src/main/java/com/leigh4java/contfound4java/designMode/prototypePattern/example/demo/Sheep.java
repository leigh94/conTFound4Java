package com.leigh4java.contfound4java.designMode.prototypePattern.example.demo;

// 实现Cloneable接口
class Sheep implements Cloneable {
    private String name;
    private int age;

    public Sheep(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 重写clone方法，实现浅拷贝
    @Override
    public Object clone() {
        try {
            return super.clone();
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

    @Override
    public String toString() {
        return "Sheep{name='" + name + "', age=" + age + '}';
    }
}