package com.leigh4java.contfound4java.designMode.facadePattern.example;

// 外观类 - 计算机
public class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    // 启动计算机的简化接口
    public void startComputer() {
        System.out.println("=== 启动计算机 ===");
        cpu.start();
        memory.load();
        hardDrive.read();
        cpu.execute();
        System.out.println("计算机启动完成！\n");
    }

    // 关闭计算机的简化接口
    public void shutdownComputer() {
        System.out.println("=== 关闭计算机 ===");
        cpu.shutdown();
        memory.free();
        System.out.println("计算机关闭完成！\n");
    }

    // 执行任务的简化接口
    public void executeTask(String task) {
        System.out.println("=== 执行任务: " + task + " ===");
        hardDrive.read();
        cpu.execute();
        hardDrive.write();
        System.out.println("任务执行完成！\n");
    }
}
