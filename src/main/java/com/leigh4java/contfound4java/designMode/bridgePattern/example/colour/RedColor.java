package com.leigh4java.contfound4java.designMode.bridgePattern.example.colour;

// 具体实现化角色 - 红色
public class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.print("应用红色");
    }

    @Override
    public String getColorName() {
        return "红色";
    }
}
