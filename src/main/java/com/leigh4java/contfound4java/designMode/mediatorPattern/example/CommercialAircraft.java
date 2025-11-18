package com.leigh4java.contfound4java.designMode.mediatorPattern.example;

// 商用客机
public class CommercialAircraft implements Aircraft {
    private AirTrafficControl atc;
    private String flightNumber;
    private int altitude;
    private int speed;
    private Position position;

    public CommercialAircraft(AirTrafficControl atc, String flightNumber,
                              Position initialPosition) {
        this.atc = atc;
        this.flightNumber = flightNumber;
        this.altitude = 0;
        this.speed = 0;
        this.position = initialPosition;
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
        atc.requestTakeoff(this, "RWY09L");
    }

    @Override
    public void changeAltitude(int newAltitude) {
        this.altitude = newAltitude;
        System.out.println(flightNumber + " 高度变更为: " + newAltitude + "ft");
    }

    @Override
    public void changeSpeed(int newSpeed) {
        this.speed = newSpeed;
        System.out.println(flightNumber + " 速度变更为: " + newSpeed + "kt");
    }

    @Override
    public void updatePosition(Position newPosition) {
        this.position = newPosition;
        System.out.println(flightNumber + " 位置更新: " + newPosition);
    }

    @Override
    public void receiveMessage(String message, String from) {
        System.out.println(flightNumber + " 收到来自 " + from + " 的消息: " + message);
    }

    // 飞机特有方法
    public void climbToCruisingAltitude() {
        atc.requestAltitudeChange(this, 35000);
    }

    public void descendForLanding() {
        atc.requestAltitudeChange(this, 5000);
    }
}
