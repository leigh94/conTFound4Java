package com.leigh4java.contfound4java.designMode.builderPattern;

/**
 * 建造者模式验证和测试
 */
public class BuilderValidation {
    public static void main(String[] args) {
        System.out.println("=== 建造者模式验证 ===\n");

        // 验证必需参数
        try {
            // 这会编译错误，因为必需参数在构造方法中
            // Computer computer = new Computer();
        } catch (Exception e) {
            System.out.println("验证通过：不能直接实例化 Computer");
        }

        // 验证链式调用
        Computer computer = new Computer.ComputerBuilder("Intel i5", "16GB", "B660主板")
                .setStorage("1TB SSD")
                .setPowerSupply("600W")
                .setMonitor("24寸 1080P")
                .enableBluetooth(true)
                .build();

        System.out.println("链式调用验证: " + computer);

        // 验证不变性
        System.out.println("\n验证产品不变性:");
        System.out.println("CPU: " + computer.getCpu());
        System.out.println("内存: " + computer.getRam());
        System.out.println("主板: " + computer.getMotherboard());
    }
}