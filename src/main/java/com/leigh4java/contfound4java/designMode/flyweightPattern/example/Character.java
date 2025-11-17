package com.leigh4java.contfound4java.designMode.flyweightPattern.example;

import java.util.HashMap;
import java.util.Map;

// 字符享元
public class Character {
    private char symbol;        // 内部状态
    private String font;        // 内部状态
    private int size;           // 内部状态

    public Character(char symbol, String font, int size) {
        this.symbol = symbol;
        this.font = font;
        this.size = size;
    }

    public void display(int position, String color) {
        System.out.println("字符: '" + symbol + "' 字体: " + font +
                " 字号: " + size + " 位置: " + position + " 颜色: " + color);
    }
}

