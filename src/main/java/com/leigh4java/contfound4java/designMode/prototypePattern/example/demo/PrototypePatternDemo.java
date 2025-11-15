package com.leigh4java.contfound4java.designMode.prototypePattern.example.demo;

import java.util.ArrayList;
import java.util.List;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        // 浅拷贝测试
        System.out.println("浅拷贝测试:");
        Sheep originalSheep = new Sheep("Dolly", 2);
        Sheep clonedSheep = (Sheep) originalSheep.clone();

        System.out.println("Original: " + originalSheep);
        System.out.println("Cloned: " + clonedSheep);

        // 修改原始对象的字段，查看克隆对象是否受影响
        originalSheep.setName("Molly");
        originalSheep.setAge(3);
        System.out.println("After modifying original:");
        System.out.println("Original: " + originalSheep);
        System.out.println("Cloned: " + clonedSheep); // 克隆对象不受影响，因为String和int都是不可变或基本类型

        // 深拷贝测试
        System.out.println("深拷贝测试:");
        List<String> friends = new ArrayList<>();
        friends.add("Sheep1");
        friends.add("Sheep2");
        DeepCloneableSheep originalDeepSheep = new DeepCloneableSheep("Dolly", 2, friends);
        DeepCloneableSheep clonedDeepSheep = (DeepCloneableSheep) originalDeepSheep.clone();

        System.out.println("Original: " + originalDeepSheep);
        System.out.println("Cloned: " + clonedDeepSheep);

        // 修改原始对象的friends列表
        originalDeepSheep.getFriends().add("Sheep3");
        System.out.println("After modifying original's friends:");
        System.out.println("Original: " + originalDeepSheep);
        System.out.println("Cloned: " + clonedDeepSheep); // 克隆对象不受影响，因为深拷贝复制了引用对象
    }
}