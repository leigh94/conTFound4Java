package com.leigh4java.contfound4java.designMode.statePattern.example;

import java.util.*;

// 具体状态 - 停止状态
class StoppedState implements ElevatorState {
    private ElevatorContext context;

    public StoppedState(ElevatorContext context) {
        this.context = context;
    }

    @Override
    public void openDoors() {
        System.out.println("🚪 电梯门已打开");
        context.setState(context.getDoorsOpenState());
    }

    @Override
    public void closeDoors() {
        System.out.println("❌ 电梯已停止，门已经是关闭状态");
    }

    @Override
    public void move() {
        System.out.println("✅ 电梯开始运行");
        context.setState(context.getMovingState());
    }

    @Override
    public void stop() {
        System.out.println("❌ 电梯已经是停止状态");
    }

    @Override
    public void repair() {
        System.out.println("🔧 电梯进入维修状态");
        context.setState(context.getMaintenanceState());
    }

    @Override
    public void maintenanceComplete() {
        System.out.println("❌ 电梯不在维修状态，无法完成维修");
    }

    @Override
    public String toString() {
        return "停止状态";
    }
}

// 具体状态 - 运行状态
class MovingState implements ElevatorState {
    private ElevatorContext context;

    public MovingState(ElevatorContext context) {
        this.context = context;
    }

    @Override
    public void openDoors() {
        System.out.println("❌ 电梯运行中，无法开门");
    }

    @Override
    public void closeDoors() {
        System.out.println("❌ 电梯运行中，门已经是关闭状态");
    }

    @Override
    public void move() {
        System.out.println("✅ 电梯继续运行");
    }

    @Override
    public void stop() {
        System.out.println("🛑 电梯停止运行");
        context.setState(context.getStoppedState());
    }

    @Override
    public void repair() {
        System.out.println("❌ 电梯运行中，无法进入维修状态");
    }

    @Override
    public void maintenanceComplete() {
        System.out.println("❌ 电梯不在维修状态，无法完成维修");
    }

    @Override
    public String toString() {
        return "运行状态";
    }
}

// 具体状态 - 门打开状态
class DoorsOpenState implements ElevatorState {
    private ElevatorContext context;

    public DoorsOpenState(ElevatorContext context) {
        this.context = context;
    }

    @Override
    public void openDoors() {
        System.out.println("❌ 电梯门已经是打开状态");
    }

    @Override
    public void closeDoors() {
        System.out.println("✅ 电梯门已关闭");
        context.setState(context.getStoppedState());
    }

    @Override
    public void move() {
        System.out.println("❌ 电梯门打开时无法运行");
    }

    @Override
    public void stop() {
        System.out.println("❌ 电梯已经是停止状态（门打开）");
    }

    @Override
    public void repair() {
        System.out.println("🔧 电梯进入维修状态");
        context.setState(context.getMaintenanceState());
    }

    @Override
    public void maintenanceComplete() {
        System.out.println("❌ 电梯不在维修状态，无法完成维修");
    }

    @Override
    public String toString() {
        return "门打开状态";
    }
}

// 具体状态 - 维修状态
class MaintenanceState implements ElevatorState {
    private ElevatorContext context;

    public MaintenanceState(ElevatorContext context) {
        this.context = context;
    }

    @Override
    public void openDoors() {
        System.out.println("❌ 维修中，无法开门");
    }

    @Override
    public void closeDoors() {
        System.out.println("❌ 维修中，无法操作门");
    }

    @Override
    public void move() {
        System.out.println("❌ 维修中，无法运行");
    }

    @Override
    public void stop() {
        System.out.println("❌ 维修中，已经是停止状态");
    }

    @Override
    public void repair() {
        System.out.println("✅ 继续维修中");
    }

    @Override
    public void maintenanceComplete() {
        System.out.println("✅ 维修完成，电梯恢复正常");
        context.setState(context.getStoppedState());
    }

    @Override
    public String toString() {
        return "维修状态";
    }
}

// 上下文类 - 电梯
class ElevatorContext {
    private ElevatorState stoppedState;
    private ElevatorState movingState;
    private ElevatorState doorsOpenState;
    private ElevatorState maintenanceState;

    private ElevatorState currentState;

    public ElevatorContext() {
        this.stoppedState = new StoppedState(this);
        this.movingState = new MovingState(this);
        this.doorsOpenState = new DoorsOpenState(this);
        this.maintenanceState = new MaintenanceState(this);

        this.currentState = stoppedState; // 初始状态为停止
    }

    // 委托给当前状态
    public void openDoors() {
        System.out.print("操作：开门 - ");
        currentState.openDoors();
    }

    public void closeDoors() {
        System.out.print("操作：关门 - ");
        currentState.closeDoors();
    }

    public void move() {
        System.out.print("操作：运行 - ");
        currentState.move();
    }

    public void stop() {
        System.out.print("操作：停止 - ");
        currentState.stop();
    }

    public void repair() {
        System.out.print("操作：维修 - ");
        currentState.repair();
    }

    public void maintenanceComplete() {
        System.out.print("操作：完成维修 - ");
        currentState.maintenanceComplete();
    }

    // 设置状态
    public void setState(ElevatorState state) {
        this.currentState = state;
        displayStatus();
    }

    public void displayStatus() {
        System.out.println("当前状态: " + currentState);
        System.out.println("------------------------");
    }

    // 获取各个状态
    public ElevatorState getStoppedState() { return stoppedState; }
    public ElevatorState getMovingState() { return movingState; }
    public ElevatorState getDoorsOpenState() { return doorsOpenState; }
    public ElevatorState getMaintenanceState() { return maintenanceState; }
}

// 演示类
public class StatePatternDemo {
    public static void main(String[] args) {
        ElevatorContext elevator = new ElevatorContext();

        System.out.println("=== 电梯状态模式演示 ===\n");

        // 显示初始状态
        elevator.displayStatus();

        // 正常使用流程
        elevator.openDoors();
        elevator.closeDoors();
        elevator.move();
        elevator.stop();
        elevator.openDoors();

        System.out.println("=== 异常操作测试 ===\n");

        // 测试异常操作
        elevator.move(); // 门开着时运行
        elevator.closeDoors();
        elevator.move();
        elevator.openDoors(); // 运行时开门

        System.out.println("=== 维修流程测试 ===\n");

        // 维修流程
        elevator.stop();
        elevator.repair();
        elevator.move(); // 维修中运行
        elevator.maintenanceComplete();

        System.out.println("=== 恢复正常使用 ===\n");

        // 恢复正常使用
        elevator.openDoors();
        elevator.closeDoors();
        elevator.move();
        elevator.stop();
    }
}