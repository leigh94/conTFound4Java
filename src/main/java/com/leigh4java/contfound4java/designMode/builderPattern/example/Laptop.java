package com.leigh4java.contfound4java.designMode.builderPattern.example;

import lombok.Builder;
import lombok.ToString;

@Builder(builderMethodName = "hiddenBuilder")
@ToString
public class Laptop {
//    private final String cpu;
//    private final String ram;
//    private final String storage;
//    private final String display;
//    @Builder.Default private final String graphicsCard = "集成显卡";
//    @Builder.Default private final boolean backlitKeyboard = false;
//    @Builder.Default private final boolean fingerprintReader = false;
//
//    // 静态工厂方法
//    public static LaptopBuilder builder(String cpu, String ram, String storage, String display) {
//        return hiddenBuilder()
//                .cpu(cpu)
//                .ram(ram)
//                .storage(storage)
//                .display(display);
//    }
}