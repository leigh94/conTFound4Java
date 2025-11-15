package com.leigh4java.contfound4java.designMode.prototypePattern.example.prototype;

import java.util.ArrayList;
import java.util.List;

// 测试类
public class PrototypePatternDemo {
    public static void main(String[] args) {
        try {
            // 准备测试数据
            List<String> hobbies = new ArrayList<>();
            hobbies.add("Reading");
            hobbies.add("Swimming");

            // 创建原型管理器
            PrototypeManager manager = new PrototypeManager();

            // 注册原型
            manager.registerPrototype("shallow", new ShallowPrototype("Alice", 25, hobbies));
            manager.registerPrototype("deep", new DeepPrototype("Bob", 30, hobbies));

            // 测试浅拷贝
            System.out.println("=== 浅拷贝测试 ===");
            ShallowPrototype shallowOriginal = (ShallowPrototype) manager.createPrototype("shallow");
            ShallowPrototype shallowClone = (ShallowPrototype) shallowOriginal.clone();

            shallowOriginal.display();
            shallowClone.display();

            // 修改原始对象的引用类型字段
            shallowOriginal.getHobbies().add("Running");
            System.out.println("\n修改原始对象的爱好列表后:");
            shallowOriginal.display();
            shallowClone.display(); // 克隆对象也会受到影响

            // 测试深拷贝
            System.out.println("\n=== 深拷贝测试 ===");
            DeepPrototype deepOriginal = (DeepPrototype) manager.createPrototype("deep");
            DeepPrototype deepClone = (DeepPrototype) deepOriginal.clone();

            deepOriginal.display();
            deepClone.display();

            // 修改原始对象的引用类型字段
            deepOriginal.getHobbies().add("Dancing");
            System.out.println("\n修改原始对象的爱好列表后:");
            deepOriginal.display();
            deepClone.display(); // 克隆对象不受影响

            // 测试原型管理器
            System.out.println("\n=== 原型管理器测试 ===");
            Prototype newShallow = manager.createPrototype("shallow");
            Prototype newDeep = manager.createPrototype("deep");

            newShallow.display();
            newDeep.display();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}