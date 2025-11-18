package com.leigh4java.contfound4java.designMode.statePattern.example;

// 状态接口
public interface ElevatorState {
    void openDoors();
    void closeDoors();
    void move();
    void stop();
    void repair();
    void maintenanceComplete();
}
