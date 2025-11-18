package com.leigh4java.contfound4java.designMode.observerPattern.example.basics;

import java.util.Observable;
import java.util.Observer;

// 使用 Java 内置 Observable 类
class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        setChanged();  // 标记状态已改变
        notifyObservers();  // 通知观察者
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        System.out.println("\n气象数据更新 - 温度: " + temperature + "°C, 湿度: " + humidity + "%, 气压: " + pressure + "hPa");
        measurementsChanged();
    }

    // 提供获取数据的方法（观察者拉取数据）
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

// 使用 Java 内置 Observer 接口
class BuiltInCurrentDisplay implements Observer, DisplayElement {
    private Observable observable;
    private float temperature;
    private float humidity;

    public BuiltInCurrentDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("内置观察者 - 当前状况: " + temperature + "°C, 湿度 " + humidity + "%");
    }
}

// 演示 Java 内置观察者 API
class BuiltInObserverDemo {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        BuiltInCurrentDisplay currentDisplay = new BuiltInCurrentDisplay(weatherData);

        weatherData.setMeasurements(25.0f, 65.0f, 1013.0f);
        weatherData.setMeasurements(27.5f, 70.0f, 1012.0f);
    }
}