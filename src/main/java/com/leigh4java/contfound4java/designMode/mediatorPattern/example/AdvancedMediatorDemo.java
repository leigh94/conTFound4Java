package com.leigh4java.contfound4java.designMode.mediatorPattern.example;

public class AdvancedMediatorDemo {
    public static void main(String[] args) {
        System.out.println("=== 高级中介者模式演示 - 空中交通管制系统 ===\n");

        // 创建中介者 - 空中交通管制
        AirTrafficControl atc = new AirTrafficControl();

        // 创建飞机
        CommercialAircraft flight123 = new CommercialAircraft(atc, "FL123",
                new Position(34.0522, -118.2437));
        CommercialAircraft flight456 = new CommercialAircraft(atc, "FL456",
                new Position(34.0525, -118.2440));
        Aircraft privateJet = new PrivateAircraft(atc, "PJ001",
                new Position(34.0530, -118.2450), "John Smith");

        System.out.println("\n=== 飞机操作 ===");
        flight123.climbToCruisingAltitude();
        flight456.climbToCruisingAltitude();
        privateJet.changeAltitude(25000);

        System.out.println("\n=== 交通状态检查 ===");
        atc.showTrafficStatus();

        System.out.println("\n=== 着陆请求 ===");
        flight123.requestLanding();
        flight456.requestLanding();

        System.out.println("\n=== ATC广播 ===");
        atc.broadcastToAll("机场即将关闭进行维护，请所有飞机尽快着陆", "ATC");

        System.out.println("\n=== 最终交通状态 ===");
        atc.showTrafficStatus();
    }
}