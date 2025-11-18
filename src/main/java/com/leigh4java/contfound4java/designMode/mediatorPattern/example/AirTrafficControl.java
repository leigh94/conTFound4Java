package com.leigh4java.contfound4java.designMode.mediatorPattern.example;

import java.util.*;

// 飞机接口
interface Aircraft {
    String getFlightNumber();
    int getAltitude();
    int getSpeed();
    Position getPosition();
    void requestLanding();
    void requestTakeoff();
    void changeAltitude(int newAltitude);
    void changeSpeed(int newSpeed);
    void updatePosition(Position newPosition);
    void receiveMessage(String message, String from);
}

// 位置类
class Position {
    private double latitude;
    private double longitude;

    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // getters
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    @Override
    public String toString() {
        return String.format("(%.4f, %.4f)", latitude, longitude);
    }

    public double distanceTo(Position other) {
        // 简化计算，实际应用中使用Haversine公式
        double latDiff = this.latitude - other.latitude;
        double lonDiff = this.longitude - other.longitude;
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }
}

// 空中交通管制中介者
public class AirTrafficControl implements ChatMediator {
    private List<Aircraft> aircrafts;
    private Map<String, Runway> runways;
    private List<String> messageLog;

    public AirTrafficControl() {
        this.aircrafts = new ArrayList<>();
        this.runways = new HashMap<>();
        this.messageLog = new ArrayList<>();
        initializeRunways();
    }

    private void initializeRunways() {
        runways.put("RWY09L", new Runway("RWY09L", true));
        runways.put("RWY09R", new Runway("RWY09R", true));
        runways.put("RWY27L", new Runway("RWY27L", false));
        runways.put("RWY27R", new Runway("RWY27R", false));
    }

    @Override
    public void sendMessage(String message, User user) {
        // 在ATC中，这个方法不适用
        throw new UnsupportedOperationException("ATC使用专门的消息发送方法");
    }

    public void sendToAircraft(String message, String from, String toFlightNumber) {
        String formattedMessage = "【ATC】来自 " + from + ": " + message;
        System.out.println(formattedMessage);
        messageLog.add(formattedMessage);

        for (Aircraft aircraft : aircrafts) {
            if (aircraft.getFlightNumber().equals(toFlightNumber)) {
                aircraft.receiveMessage(message, from);
                break;
            }
        }
    }

    public void broadcastToAll(String message, String from) {
        String formattedMessage = "【ATC广播】来自 " + from + ": " + message;
        System.out.println(formattedMessage);
        messageLog.add(formattedMessage);

        for (Aircraft aircraft : aircrafts) {
            aircraft.receiveMessage(message, from);
        }
    }

    @Override
    public void addUser(User user) {
        // 在ATC中，这个方法不适用
        throw new UnsupportedOperationException("ATC使用addAircraft方法");
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
        System.out.println("飞机 " + aircraft.getFlightNumber() + " 进入管制区域");

        // 检查空中交通冲突
        checkTrafficConflicts();
    }

    @Override
    public void removeUser(User user) {
        // 在ATC中，这个方法不适用
        throw new UnsupportedOperationException("ATC使用removeAircraft方法");
    }

    public void removeAircraft(Aircraft aircraft) {
        if (aircrafts.remove(aircraft)) {
            System.out.println("飞机 " + aircraft.getFlightNumber() + " 离开管制区域");
        }
    }

    // 处理着陆请求
    public void requestLanding(Aircraft aircraft) {
        System.out.println("飞机 " + aircraft.getFlightNumber() + " 请求着陆");

        // 寻找可用跑道
        Runway availableRunway = findAvailableRunway();
        if (availableRunway != null) {
            availableRunway.setOccupied(true);
            sendToAircraft("允许在跑道 " + availableRunway.getName() + " 着陆", "ATC",
                    aircraft.getFlightNumber());
        } else {
            sendToAircraft("暂时没有可用跑道，请保持等待模式", "ATC", aircraft.getFlightNumber());
        }
    }

    // 处理起飞请求
    public void requestTakeoff(Aircraft aircraft, String runwayName) {
        System.out.println("飞机 " + aircraft.getFlightNumber() + " 请求在跑道 " + runwayName + " 起飞");

        Runway runway = runways.get(runwayName);
        if (runway != null && !runway.isOccupied()) {
            runway.setOccupied(true);
            sendToAircraft("允许在跑道 " + runwayName + " 起飞", "ATC", aircraft.getFlightNumber());
        } else {
            sendToAircraft("跑道 " + runwayName + " 不可用", "ATC", aircraft.getFlightNumber());
        }
    }

    // 处理高度变更请求
    public void requestAltitudeChange(Aircraft aircraft, int newAltitude) {
        System.out.println("飞机 " + aircraft.getFlightNumber() + " 请求变更高度到 " + newAltitude + " 英尺");

        // 检查高度冲突
        if (isAltitudeAvailable(newAltitude, aircraft)) {
            sendToAircraft("允许变更高度到 " + newAltitude + " 英尺", "ATC",
                    aircraft.getFlightNumber());
            aircraft.changeAltitude(newAltitude);
        } else {
            sendToAircraft("高度 " + newAltitude + " 英尺不可用，请保持当前高度", "ATC",
                    aircraft.getFlightNumber());
        }
    }

    private Runway findAvailableRunway() {
        return runways.values().stream()
                .filter(runway -> !runway.isOccupied())
                .findFirst()
                .orElse(null);
    }

    private boolean isAltitudeAvailable(int altitude, Aircraft requestingAircraft) {
        // 检查是否有其他飞机在相同或相近高度
        for (Aircraft aircraft : aircrafts) {
            if (aircraft != requestingAircraft &&
                    Math.abs(aircraft.getAltitude() - altitude) < 1000) {
                // 检查水平距离
                double distance = aircraft.getPosition().distanceTo(requestingAircraft.getPosition());
                if (distance < 10.0) { // 10公里内
                    return false;
                }
            }
        }
        return true;
    }

    private void checkTrafficConflicts() {
        for (int i = 0; i < aircrafts.size(); i++) {
            for (int j = i + 1; j < aircrafts.size(); j++) {
                Aircraft a1 = aircrafts.get(i);
                Aircraft a2 = aircrafts.get(j);

                double distance = a1.getPosition().distanceTo(a2.getPosition());
                int altDiff = Math.abs(a1.getAltitude() - a2.getAltitude());

                if (distance < 5.0 && altDiff < 500) { // 5公里内且高度差小于500英尺
                    System.out.println("【警告】交通冲突: " + a1.getFlightNumber() + " 和 " +
                            a2.getFlightNumber());
                    sendToAircraft("注意交通冲突，请立即改变高度或航向", "ATC", a1.getFlightNumber());
                    sendToAircraft("注意交通冲突，请立即改变高度或航向", "ATC", a2.getFlightNumber());
                }
            }
        }
    }

    public void showTrafficStatus() {
        System.out.println("\n=== 空中交通状态 ===");
        for (Aircraft aircraft : aircrafts) {
            System.out.println(aircraft.getFlightNumber() +
                    " - 高度: " + aircraft.getAltitude() + "ft, " +
                    "速度: " + aircraft.getSpeed() + "kt, " +
                    "位置: " + aircraft.getPosition());
        }

        System.out.println("\n=== 跑道状态 ===");
        for (Runway runway : runways.values()) {
            System.out.println(runway.getName() + ": " +
                    (runway.isOccupied() ? "占用" : "可用"));
        }
    }
}

// 跑道类
class Runway {
    private String name;
    private boolean occupied;

    public Runway(String name, boolean occupied) {
        this.name = name;
        this.occupied = occupied;
    }

    // getters and setters
    public String getName() { return name; }
    public boolean isOccupied() { return occupied; }
    public void setOccupied(boolean occupied) { this.occupied = occupied; }
}