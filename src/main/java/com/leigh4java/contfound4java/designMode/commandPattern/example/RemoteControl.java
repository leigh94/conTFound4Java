package com.leigh4java.contfound4java.designMode.commandPattern.example;

import java.util.Stack;

// 遥控器 - 调用者
public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public RemoteControl(int slots) {
        onCommands = new Command[slots];
        offCommands = new Command[slots];
        undoStack = new Stack<>();
        redoStack = new Stack<>();

        // 初始化空命令
        Command noCommand = new NoCommand();
        for (int i = 0; i < slots; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    // 设置命令
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot >= 0 && slot < onCommands.length) {
            onCommands[slot] = onCommand;
            offCommands[slot] = offCommand;
        }
    }

    // 按下开按钮
    public void pressOnButton(int slot) {
        if (slot >= 0 && slot < onCommands.length) {
            onCommands[slot].execute();
            undoStack.push(onCommands[slot]);
            redoStack.clear(); // 新的命令清空重做栈
        }
    }

    // 按下关按钮
    public void pressOffButton(int slot) {
        if (slot >= 0 && slot < offCommands.length) {
            offCommands[slot].execute();
            undoStack.push(offCommands[slot]);
            redoStack.clear();
        }
    }

    // 撤销
    public void pressUndoButton() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        } else {
            System.out.println("没有可以撤销的操作");
        }
    }

    // 重做
    public void pressRedoButton() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        } else {
            System.out.println("没有可以重做的操作");
        }
    }

    // 显示遥控器设置
    public void display() {
        System.out.println("\n------ 遥控器设置 ------");
        for (int i = 0; i < onCommands.length; i++) {
            System.out.println("[插槽 " + i + "] " +
                    onCommands[i].getClass().getSimpleName() + "    " +
                    offCommands[i].getClass().getSimpleName());
        }
    }
}


