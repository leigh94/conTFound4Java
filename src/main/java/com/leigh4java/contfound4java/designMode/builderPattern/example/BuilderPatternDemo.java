package com.leigh4java.contfound4java.designMode.builderPattern.example;

/**
 * 客户端演示类
 */
//public class BuilderPatternDemo {
//    public static void main(String[] args) {
//        System.out.println("=== 建造者模式演示 ===\n");
//
//        // 演示1：直接使用建造者
//        testDirectBuilder();
//
//        // 演示2：使用导演类
//        testWithDirector();
//
//        // 演示3：使用 Lombok 建造者
//        testLombokBuilder();
//
//        // 演示4：复杂构建场景
//        testComplexScenarios();
//    }
//
//    private static void testDirectBuilder() {
//        System.out.println("1. 直接使用建造者:");
//
//        // 链式调用构建电脑
//        Computer gamingPC = new Computer.ComputerBuilder("AMD Ryzen 9", "32GB", "X670主板")
//                .setGraphicsCard("RX 7900 XTX")
//                .setStorage("2TB NVMe SSD")
//                .setPowerSupply("1000W")
//                .setMonitor("32寸 4K 165Hz")
//                .enableBluetooth(true)
//                .build();
//
//        System.out.println("游戏电脑: " + gamingPC);
//
//        // 最小配置电脑
//        Computer minimalPC = new Computer.ComputerBuilder("Intel i3", "8GB", "H610主板")
//                .build();
//
//        System.out.println("最小配置: " + minimalPC);
//        System.out.println();
//    }
//
//    private static void testWithDirector() {
//        System.out.println("2. 使用导演类:");
//
//        ComputerDirector director = new ComputerDirector();
//
//        Computer gaming = director.buildGamingComputer();
//        Computer office = director.buildOfficeComputer();
//        Computer budget = director.buildBudgetComputer();
//
//        System.out.println("游戏配置: " + gaming);
//        System.out.println("办公配置: " + office);
//        System.out.println("经济配置: " + budget);
//        System.out.println();
//    }
//
//    private static void testLombokBuilder() {
//        System.out.println("3. 使用 Lombok 建造者:");
//
//        // 使用 Lombok 生成的建造者
//        Laptop gamingLaptop = Laptop.builder()
//                .cpu("Intel i7")
//                .ram("16GB")
//                .storage("1TB SSD")
//                .display("15.6寸 2K")
//                .graphicsCard("RTX 3060")
//                .backlitKeyboard(true)
//                .fingerprintReader(true)
//                .build();
//
//        System.out.println("游戏笔记本: " + gamingLaptop);
//
//        // 部分参数使用默认值
//        Laptop studentLaptop = Laptop.builder()
//                .cpu("Intel i5")
//                .ram("8GB")
//                .storage("512GB SSD")
//                .display("14寸 1080P")
//                .build();
//
//        System.out.println("学生笔记本: " + studentLaptop);
//        System.out.println();
//    }
//
//    private static void testComplexScenarios() {
//        System.out.println("4. 复杂构建场景:");
//
//        // 场景1：逐步构建
//        Computer.ComputerBuilder builder = new Computer.ComputerBuilder("Intel i7", "16GB", "B760主板");
//
//        // 根据条件动态添加组件
//        boolean isGamer = true;
//        if (isGamer) {
//            builder.setGraphicsCard("RTX 4070")
//                    .setMonitor("27寸 2K 170Hz");
//        }
//
//        boolean needsStorage = true;
//        if (needsStorage) {
//            builder.setStorage("1TB SSD");
//        }
//
//        Computer customPC = builder.build();
//        System.out.println("自定义电脑: " + customPC);
//
//        // 场景2：从配置构建
//        buildFromConfiguration();
//    }
//
//    private static void buildFromConfiguration() {
//        System.out.println("\n5. 从配置构建:");
//
//        // 模拟从配置文件读取
//        ComputerConfig config = new ComputerConfig("AMD Ryzen 7", "32GB DDR5", "X670E");
//        config.setGraphicsCard("RX 7800 XT");
//        config.setStorage("2TB Gen4 SSD");
//
//        Computer configuredPC = config.buildComputer();
//        System.out.println("配置构建: " + configuredPC);
//    }
//}

/**
 * 配置类 - 演示另一种构建方式
 */
class ComputerConfig {
    private String cpu;
    private String ram;
    private String motherboard;
    private String graphicsCard;
    private String storage;
    private String powerSupply = "750W";
    private String monitor = "27寸 2K";
    private boolean bluetoothEnabled = true;

    public ComputerConfig(String cpu, String ram, String motherboard) {
        this.cpu = cpu;
        this.ram = ram;
        this.motherboard = motherboard;
    }

    // Setters
    public void setGraphicsCard(String graphicsCard) { this.graphicsCard = graphicsCard; }
    public void setStorage(String storage) { this.storage = storage; }
    public void setPowerSupply(String powerSupply) { this.powerSupply = powerSupply; }
    public void setMonitor(String monitor) { this.monitor = monitor; }
    public void setBluetoothEnabled(boolean bluetoothEnabled) { this.bluetoothEnabled = bluetoothEnabled; }

    public Computer buildComputer() {
        Computer.ComputerBuilder builder = new Computer.ComputerBuilder(cpu, ram, motherboard);

        if (graphicsCard != null) builder.setGraphicsCard(graphicsCard);
        if (storage != null) builder.setStorage(storage);
        if (powerSupply != null) builder.setPowerSupply(powerSupply);
        if (monitor != null) builder.setMonitor(monitor);

        return builder.enableBluetooth(bluetoothEnabled).build();
    }
}