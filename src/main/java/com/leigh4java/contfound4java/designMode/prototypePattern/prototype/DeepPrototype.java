package com.leigh4java.contfound4java.designMode.prototypePattern.prototype;

import java.util.ArrayList;
import java.util.List;

// 具体原型类 - 深拷贝
public class DeepPrototype implements Prototype {
    private String name;
    private int age;
    private List<String> hobbies; // 引用类型字段

    public DeepPrototype(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>(hobbies); // 创建新的列表
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        DeepPrototype cloned = (DeepPrototype) super.clone();
        // 对引用类型字段进行深拷贝
        cloned.hobbies = new ArrayList<>(this.hobbies);
        return cloned;
    }

    @Override
    public void display() {
        System.out.println("DeepPrototype: " + name + ", " + age + ", Hobbies: " + hobbies);
    }

    // Getter 和 Setter 方法
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

    public List<String> getHobbies() {
        return new ArrayList<>(hobbies);
    } // 返回副本

    public void setHobbies(List<String> hobbies) {
        this.hobbies = new ArrayList<>(hobbies);
    }
}
