package com.leigh4java.contfound4java.designMode.facadePattern.example;

// 客户端代码
public class FacadePatternDemo {
    public static void main(String[] args) {
        // 创建计算机外观
        ComputerFacade computer = new ComputerFacade();

        // 使用简化接口操作计算机
        computer.startComputer();
        computer.executeTask("图像处理");
        computer.executeTask("数据分析");
        computer.shutdownComputer();

        // 对比：如果不使用外观模式，客户端需要直接与所有子系统交互
        System.out.println("=== 不使用外观模式 ===");
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();

        cpu.start();
        memory.load();
        hardDrive.read();
        cpu.execute();
        // ... 更多复杂的交互
    }
}
