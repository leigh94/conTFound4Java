package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 条件命令 - 只有满足条件才执行
public class ConditionalCommand implements Command {
    private Command command;
    private Condition condition;

    public ConditionalCommand(Command command, Condition condition) {
        this.command = command;
        this.condition = condition;
    }

    @Override
    public void execute() {
        if (condition.test()) {
            command.execute();
        } else {
            System.out.println("条件不满足，命令未执行");
        }
    }

    @Override
    public void undo() {
        command.undo();
    }

    // 条件接口
    public interface Condition {
        boolean test();
    }
}
