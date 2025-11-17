package com.leigh4java.contfound4java.designMode.commandPattern.example;

import java.util.Arrays;
import java.util.List;

public class AdvancedCommandDemo {
    public static void main(String[] args) {
        System.out.println("=== 高级命令模式演示 ===\n");

        // 创建设备
        Light bedroomLight = new Light("卧室");
        Light bathroomLight = new Light("浴室");
        TV bedroomTV = new TV("卧室");
        Stereo livingRoomStereo = new Stereo("客厅");

        // 创建基础命令
        Command bedroomLightOn = new LightOnCommand(bedroomLight);
        Command bedroomLightOff = new LightOffCommand(bedroomLight);
        Command bathroomLightOn = new LightOnCommand(bathroomLight);
        Command bathroomLightOff = new LightOffCommand(bathroomLight);
        Command tvOn = new TVOnCommand(bedroomTV);
        Command tvOff = new TVOffCommand(bedroomTV);
        Command stereoOn = new Command() {
            @Override
            public void execute() {
                livingRoomStereo.on();
                livingRoomStereo.setCD();
                livingRoomStereo.setVolume(25);
            }

            @Override
            public void undo() {
                livingRoomStereo.off();
            }
        };

        // 创建宏命令 - 早晨起床场景
        List<Command> morningRoutine = Arrays.asList(
                new LoggingCommand(bedroomLightOn, "打开卧室灯"),
                new LoggingCommand(tvOn, "打开电视"),
                new DelayedCommand(bathroomLightOn, 2000), // 2秒后打开浴室灯
                new ConditionalCommand(stereoOn, () -> true) // 总是执行的条件命令
        );

        MacroCommand morningMacro = new MacroCommand("早晨起床", morningRoutine);

        // 创建宏命令 - 晚上睡觉场景
        List<Command> nightRoutine = Arrays.asList(
                new LoggingCommand(tvOff, "关闭电视"),
                new LoggingCommand(bedroomLightOff, "关闭卧室灯"),
                new LoggingCommand(bathroomLightOff, "关闭浴室灯"),
                new ConditionalCommand(new Command() {
                    @Override
                    public void execute() {
                        System.out.println("启动安防系统");
                    }

                    @Override
                    public void undo() {
                        System.out.println("关闭安防系统");
                    }
                }, () -> true)
        );

        MacroCommand nightMacro = new MacroCommand("晚上睡觉", nightRoutine);

        // 测试宏命令
        System.out.println("=== 执行早晨起床宏命令 ===");
        morningMacro.execute();

        System.out.println("=== 执行晚上睡觉宏命令 ===");
        nightMacro.execute();

        System.out.println("=== 撤销晚上睡觉宏命令 ===");
        nightMacro.undo();

        System.out.println("=== 撤销早晨起床宏命令 ===");
        morningMacro.undo();

        // 测试延迟命令
        System.out.println("=== 测试延迟命令 ===");
        Command delayedLight = new DelayedCommand(bedroomLightOn, 3000);
        delayedLight.execute();

        // 等待延迟命令执行
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
