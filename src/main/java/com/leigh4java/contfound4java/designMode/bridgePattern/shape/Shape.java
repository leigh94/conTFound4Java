package com.leigh4java.contfound4java.designMode.bridgePattern.shape;

import com.leigh4java.contfound4java.designMode.bridgePattern.colour.Color;

// 形状抽象类 - 抽象化角色
public abstract class Shape {
    protected Color color;

    // 通过构造器注入颜色实现
    public Shape(Color color) {
        this.color = color;
    }

    // 设置颜色实现
    public void setColor(Color color) {
        this.color = color;
    }

    // 抽象方法 - 绘制形状
    public abstract void draw();

    // 抽象方法 - 获取形状信息
    public abstract String getShapeInfo();
}