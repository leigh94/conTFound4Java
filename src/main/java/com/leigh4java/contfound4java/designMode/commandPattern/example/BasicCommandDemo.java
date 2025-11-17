package com.leigh4java.contfound4java.designMode.commandPattern.example;

public class BasicCommandDemo {
    public static void main(String[] args) {
        System.out.println("=== 基础命令模式演示 - 智能家居遥控器 ===\n");

        // 创建设备
        Light livingRoomLight = new Light("客厅");
        Light kitchenLight = new Light("厨房");
        TV livingRoomTV = new TV("客厅");
        Stereo livingRoomStereo = new Stereo("客厅");

        // 创建命令
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);
        Command tvOn = new TVOnCommand(livingRoomTV);
        Command tvOff = new TVOffCommand(livingRoomTV);
        Command stereoVolumeUp = new StereoVolumeCommand(livingRoomStereo, 30);

        // 创建遥控器
        RemoteControl remote = new RemoteControl(5);

        // 设置命令到插槽
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, tvOn, tvOff);
        remote.setCommand(3, stereoVolumeUp, new NoCommand());

        // 显示遥控器设置
        remote.display();

        // 测试命令
        System.out.println("\n=== 执行命令 ===");
        remote.pressOnButton(0);  // 打开客厅灯
        remote.pressOnButton(1);  // 打开厨房灯
        remote.pressOnButton(2);  // 打开电视
        remote.pressOnButton(3);  // 调节音响音量

        System.out.println("\n=== 撤销操作 ===");
        remote.pressUndoButton(); // 撤销音量调节
        remote.pressUndoButton(); // 撤销打开电视
        remote.pressUndoButton(); // 撤销打开厨房灯

        System.out.println("\n=== 重做操作 ===");
        remote.pressRedoButton(); // 重做打开厨房灯
        remote.pressRedoButton(); // 重做打开电视

        System.out.println("\n=== 关闭设备 ===");
        remote.pressOffButton(0); // 关闭客厅灯
        remote.pressOffButton(1); // 关闭厨房灯
        remote.pressOffButton(2); // 关闭电视

        System.out.println("\n=== 再次撤销/重做 ===");
        remote.pressUndoButton(); // 撤销关闭电视
        remote.pressUndoButton(); // 撤销关闭厨房灯
        remote.pressRedoButton(); // 重做关闭厨房灯
    }
}
