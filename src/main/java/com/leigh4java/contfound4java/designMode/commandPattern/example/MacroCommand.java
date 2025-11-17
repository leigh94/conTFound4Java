package com.leigh4java.contfound4java.designMode.commandPattern.example;

import java.util.ArrayList;
import java.util.List;

// 宏命令 - 一次执行多个命令
public class MacroCommand implements Command {
    private List<Command> commands;
    private String name;

    public MacroCommand(String name, List<Command> commands) {
        this.name = name;
        this.commands = new ArrayList<>(commands);
    }

    @Override
    public void execute() {
        System.out.println("=== 开始执行宏命令: " + name + " ===");
        for (Command command : commands) {
            command.execute();
        }
        System.out.println("=== 宏命令执行完成 ===\n");
    }

    @Override
    public void undo() {
        System.out.println("=== 撤销宏命令: " + name + " ===");
        // 按相反顺序撤销
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
        System.out.println("=== 宏命令撤销完成 ===\n");
    }
}
