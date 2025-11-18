package com.leigh4java.contfound4java.designMode.observerPattern.example.basics;

import java.util.ArrayList;
import java.util.List;

// 推模型实现 - 主题主动发送数据
class PushWeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private WeatherData data;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            // 推模型：主动发送所有数据
            observer.update(data.temperature, data.humidity, data.pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.data = new WeatherData(temperature, humidity, pressure);
        notifyObservers();
    }

    // 内部数据类
    private static class WeatherData {
        float temperature;
        float humidity;
        float pressure;

        WeatherData(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
        }
    }
}

// 拉模型实现 - 观察者根据需要拉取数据
interface PullSubject {
    void registerObserver(PullObserver observer);
    void removeObserver(PullObserver observer);
    void notifyObservers();
    float getTemperature();
    float getHumidity();
    float getPressure();
}

interface PullObserver {
    void update();
}

class PullWeatherStation implements PullSubject {
    private List<PullObserver> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(PullObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(PullObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (PullObserver observer : observers) {
            // 拉模型：观察者自己获取需要的数据
            observer.update();
        }
    }

    @Override
    public float getTemperature() {
        return temperature;
    }

    @Override
    public float getHumidity() {
        return humidity;
    }

    @Override
    public float getPressure() {
        return pressure;
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}
