package com.leigh4java.contfound4java.designMode.mementoPattern.example.advanced;

import java.io.Serializable;

// 位置类
public class Position implements Serializable {
    private int x;
    private int y;
    private String map;

    public Position(int x, int y, String map) {
        this.x = x;
        this.y = y;
        this.map = map;
    }

    // getters and setters
    public int getX() { return x; }
    public int getY() { return y; }
    public String getMap() { return map; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setMap(String map) { this.map = map; }

    @Override
    public String toString() {
        return String.format("%s(%d,%d)", map, x, y);
    }
}
