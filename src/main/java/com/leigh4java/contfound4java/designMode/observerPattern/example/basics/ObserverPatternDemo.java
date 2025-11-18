package com.leigh4java.contfound4java.designMode.observerPattern.example.basics;

import java.util.ArrayList;
import java.util.List;

// 1. 主题接口 (被观察者)
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 2. 观察者接口
interface Observer {
    void update(float temperature, float humidity, float pressure);
}

// 3. 显示接口
interface DisplayElement {
    void display();
}

// 4. 具体主题 - 气象站
class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("观察者已注册: " + observer.getClass().getSimpleName());
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("观察者已移除: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers() {
        System.out.println("\n=== 通知所有观察者 ===");
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // 当气象数据更新时调用此方法
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        System.out.println("\n气象数据更新 - 温度: " + temperature + "°C, 湿度: " + humidity + "%, 气压: " + pressure + "hPa");
        notifyObservers();
    }

    public void showObservers() {
        System.out.println("\n当前观察者数量: " + observers.size());
        for (Observer observer : observers) {
            System.out.println(" - " + observer.getClass().getSimpleName());
        }
    }
}

// 5. 具体观察者 - 当前状况显示
class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherStation;

    public CurrentConditionsDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("当前状况: " + temperature + "°C, 湿度 " + humidity + "%");
    }

    public void unsubscribe() {
        weatherStation.removeObserver(this);
    }
}

// 6. 具体观察者 - 统计显示
class StatisticsDisplay implements Observer, DisplayElement {
    private List<Float> temperatures;
    private float maxTemp = Float.MIN_VALUE;
    private float minTemp = Float.MAX_VALUE;
    private float tempSum = 0.0f;
    private int numReadings = 0;

    public StatisticsDisplay(Subject weatherStation) {
        this.temperatures = new ArrayList<>();
        weatherStation.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        temperatures.add(temperature);
        tempSum += temperature;
        numReadings++;

        if (temperature > maxTemp) {
            maxTemp = temperature;
        }
        if (temperature < minTemp) {
            minTemp = temperature;
        }
        display();
    }

    @Override
    public void display() {
        float avgTemp = tempSum / numReadings;
        System.out.println("温度统计: 平均 " + String.format("%.1f", avgTemp) + "°C, 最高 " + maxTemp + "°C, 最低 " + minTemp + "°C");
    }
}

// 7. 具体观察者 - 天气预报显示
class ForecastDisplay implements Observer, DisplayElement {
    private float lastPressure;
    private float currentPressure = 29.92f;

    public ForecastDisplay(Subject weatherStation) {
        weatherStation.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.print("天气预报: ");
        if (currentPressure > lastPressure) {
            System.out.println("天气将改善！");
        } else if (currentPressure == lastPressure) {
            System.out.println("天气基本不变");
        } else {
            System.out.println("天气可能变差");
        }
    }
}

// 8. 客户端代码
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // 创建气象站（主题）
        WeatherStation weatherStation = new WeatherStation();

        // 创建显示面板（观察者）
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherStation);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherStation);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherStation);

        // 显示当前观察者
        weatherStation.showObservers();

        // 模拟气象数据更新
        System.out.println("\n=== 第一次数据更新 ===");
        weatherStation.setMeasurements(25.0f, 65.0f, 1013.0f);

        System.out.println("\n=== 第二次数据更新 ===");
        weatherStation.setMeasurements(27.5f, 70.0f, 1012.0f);

        System.out.println("\n=== 第三次数据更新 ===");
        weatherStation.setMeasurements(23.0f, 90.0f, 1010.0f);

        // 演示取消订阅
        System.out.println("\n=== 取消当前状况显示的订阅 ===");
        currentDisplay.unsubscribe();
        weatherStation.showObservers();

        System.out.println("\n=== 第四次数据更新（取消订阅后） ===");
        weatherStation.setMeasurements(20.0f, 75.0f, 1015.0f);
    }
}