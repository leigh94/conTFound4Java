package com.leigh4java.contfound4java.designMode.builderPattern;

/**
 * 导演类 - 封装常见的构建过程
 */
public class ComputerDirector {

    // 构建游戏电脑
    public Computer buildGamingComputer() {
        return new Computer.ComputerBuilder("Intel i9", "32GB DDR5", "Z690主板")
                .setGraphicsCard("RTX 4080")
                .setStorage("2TB NVMe SSD")
                .setPowerSupply("850W Gold")
                .setMonitor("27寸 4K 144Hz")
                .enableBluetooth(true)
                .build();
    }

    // 构建办公电脑
    public Computer buildOfficeComputer() {
        return new Computer.ComputerBuilder("Intel i5", "16GB DDR4", "B660主板")
                .setStorage("512GB SSD")
                .setPowerSupply("450W")
                .setMonitor("24寸 1080P")
                .enableBluetooth(true)
                .build();
    }

    // 构建经济型电脑
    public Computer buildBudgetComputer() {
        return new Computer.ComputerBuilder("Intel i3", "8GB DDR4", "H610主板")
                .setStorage("256GB SSD")
                .setPowerSupply("400W")
                .build();
    }

    // 自定义构建
    public Computer buildCustomComputer(String cpu, String ram, String motherboard) {
        return new Computer.ComputerBuilder(cpu, ram, motherboard).build();
    }
}