package com.leigh4java.contfound4java.designMode.builderPattern.example;

/**
 * 产品类 - 计算机
 */
public class Computer {
    // 必需部件
    private String cpu;
    private String ram;
    private String motherboard;

    // 可选部件
    private String graphicsCard;
    private String storage;
    private String powerSupply;
    private String monitor;
    private boolean bluetoothEnabled;

    // 私有构造方法，只能通过建造者创建
    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.motherboard = builder.motherboard;
        this.graphicsCard = builder.graphicsCard;
        this.storage = builder.storage;
        this.powerSupply = builder.powerSupply;
        this.monitor = builder.monitor;
        this.bluetoothEnabled = builder.bluetoothEnabled;
    }

    // Getters
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getMotherboard() { return motherboard; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getStorage() { return storage; }
    public String getPowerSupply() { return powerSupply; }
    public String getMonitor() { return monitor; }
    public boolean isBluetoothEnabled() { return bluetoothEnabled; }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", storage='" + storage + '\'' +
                ", powerSupply='" + powerSupply + '\'' +
                ", monitor='" + monitor + '\'' +
                ", bluetoothEnabled=" + bluetoothEnabled +
                '}';
    }

    /**
     * 建造者类 - 静态内部类
     */
    public static class ComputerBuilder {
        // 必需参数
        private final String cpu;
        private final String ram;
        private final String motherboard;

        // 可选参数 - 使用默认值
        private String graphicsCard = "集成显卡";
        private String storage = "256GB SSD";
        private String powerSupply = "500W";
        private String monitor = "无显示器";
        private boolean bluetoothEnabled = false;

        // 建造者构造方法，包含必需参数
        public ComputerBuilder(String cpu, String ram, String motherboard) {
            this.cpu = cpu;
            this.ram = ram;
            this.motherboard = motherboard;
        }

        // 设置可选参数的方法，返回建造者本身以支持链式调用
        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public ComputerBuilder setMonitor(String monitor) {
            this.monitor = monitor;
            return this;
        }

        public ComputerBuilder enableBluetooth(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        // 构建方法，返回最终的产品
        public Computer build() {
            return new Computer(this);
        }
    }
}