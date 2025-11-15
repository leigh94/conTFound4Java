package com.leigh4java.contfound4java.designMode.prototypePattern.example.prototype;

public interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;
    void display();
}
