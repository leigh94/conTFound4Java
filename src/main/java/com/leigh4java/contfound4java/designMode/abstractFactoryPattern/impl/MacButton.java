package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl;

// Mac按钮
public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("渲染Mac风格按钮");
    }

    @Override
    public void onClick() {
        System.out.println("Mac按钮被点击");
    }
}
