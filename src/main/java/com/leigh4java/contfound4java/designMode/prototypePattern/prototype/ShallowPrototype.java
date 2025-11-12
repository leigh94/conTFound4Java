package com.leigh4java.contfound4java.designMode.prototypePattern.prototype;

import java.util.List;

// 具体原型类 - 浅拷贝
public class ShallowPrototype implements Prototype {
    private String name;
    private int age;
    private List<String> hobbies; // 引用类型字段

    public ShallowPrototype(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (ShallowPrototype) super.clone(); // 浅拷贝
    }

    @Override
    public void display() {
        System.out.println("ShallowPrototype: " + name + ", " + age + ", Hobbies: " + hobbies);
    }

    // Getter 和 Setter 方法
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public List<String> getHobbies() { return hobbies; }
    public void setHobbies(List<String> hobbies) { this.hobbies = hobbies; }
}
