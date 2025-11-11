package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl;

import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.Button;

// Windows按钮
public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("渲染Windows风格按钮");
    }

    @Override
    public void onClick() {
        System.out.println("Windows按钮被点击");
    }
}


