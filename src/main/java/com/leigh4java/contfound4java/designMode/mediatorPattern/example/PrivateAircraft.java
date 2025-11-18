package com.leigh4java.contfound4java.designMode.mediatorPattern.example;

// 私人飞机
public class PrivateAircraft implements Aircraft {
    private AirTrafficControl atc;
    private String flightNumber;
    private int altitude;
    private int speed;
    private Position position;
    private String owner;

    public PrivateAircraft(AirTrafficControl atc, String flightNumber,
                           Position initialPosition, String owner) {
        this.atc = atc;
        this.flightNumber = flightNumber;
        this.altitude = 0;
        this.speed = 0;
        this.position = initialPosition;
        this.owner = owner;
        this.atc.addAircraft(this);
    }

    @Override
    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public int getAltitude() {
        return altitude;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void requestLanding() {
        atc.requestLanding(this);
    }

    @Override
    public void requestTakeoff() {
        atc.requestTakeoff(this, "RWY27R");
    }

    @Override
    public void changeAltitude(int newAltitude) {
        this.altitude = newAltitude;
        System.out.println(flightNumber + " (私人飞机) 高度变更为: " + newAltitude + "ft");
    }

    @Override
    public void changeSpeed(int newSpeed) {
        this.speed = newSpeed;
        System.out.println(flightNumber + " (私人飞机) 速度变更为: " + newSpeed + "kt");
    }

    @Override
    public void updatePosition(Position newPosition) {
        this.position = newPosition;
        System.out.println(flightNumber + " (私人飞机) 位置更新: " + newPosition);
    }

    @Override
    public void receiveMessage(String message, String from) {
        System.out.println(flightNumber + " (私人飞机) 收到来自 " + from + " 的消息: " + message);
    }

    public String getOwner() {
        return owner;
    }
}