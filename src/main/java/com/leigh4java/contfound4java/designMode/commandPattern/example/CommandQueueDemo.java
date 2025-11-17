package com.leigh4java.contfound4java.designMode.commandPattern.example;

import java.util.Arrays;

public class CommandQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 命令队列演示 ===\n");

        CommandExecutor executor = new CommandExecutor();

        // 创建设备
        Light officeLight = new Light("办公室");
        TV meetingRoomTV = new TV("会议室");
        Stereo lobbyStereo = new Stereo("大堂");

        // 创建命令
        Command[] commands = {
                new LightOnCommand(officeLight),
                new TVOnCommand(meetingRoomTV),
                new LoggingCommand(new Command() {
                    @Override
                    public void execute() {
                        lobbyStereo.on();
                        lobbyStereo.setVolume(15);
                    }

                    @Override
                    public void undo() {
                        lobbyStereo.off();
                    }
                }, "打开大堂音响"),
                new DelayedCommand(new LightOffCommand(officeLight), 1000),
                new MacroCommand("会议准备", Arrays.asList(
                        new TVOnCommand(meetingRoomTV),
                        new LightOnCommand(officeLight)
                ))
        };

        // 提交命令到队列
        System.out.println("=== 提交命令到队列 ===");
        for (Command command : commands) {
            executor.submitCommand(command);
            System.out.println("命令已提交，队列大小: " + executor.getQueueSize());
            Thread.sleep(500); // 模拟命令产生间隔
        }

        // 等待命令执行完成
        Thread.sleep(3000);

        System.out.println("\n=== 执行撤销操作 ===");
        executor.undo(); // 撤销宏命令
        executor.undo(); // 撤销延迟关灯
        executor.undo(); // 撤销打开音响

        System.out.println("\n=== 执行重做操作 ===");
        executor.redo(); // 重做打开音响
        executor.redo(); // 重做延迟关灯

        // 关闭执行器
        Thread.sleep(2000);
        executor.shutdown();
    }
}
