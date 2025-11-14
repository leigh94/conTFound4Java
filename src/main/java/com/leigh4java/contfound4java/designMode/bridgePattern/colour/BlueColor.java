package com.leigh4java.contfound4java.designMode.bridgePattern.colour;

// 具体实现化角色 - 蓝色
public class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.print("应用蓝色");
    }

    @Override
    public String getColorName() {
        return "蓝色";
    }
}

