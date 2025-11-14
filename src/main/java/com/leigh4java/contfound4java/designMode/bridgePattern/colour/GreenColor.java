package com.leigh4java.contfound4java.designMode.bridgePattern.colour;

// 具体实现化角色 - 绿色
public class GreenColor implements Color {
    @Override
    public void applyColor() {
        System.out.print("应用绿色");
    }

    @Override
    public String getColorName() {
        return "绿色";
    }
}