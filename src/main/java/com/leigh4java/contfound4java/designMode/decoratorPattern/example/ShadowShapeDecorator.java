package com.leigh4java.contfound4java.designMode.decoratorPattern.example;

public class ShadowShapeDecorator extends ShapeDecorator {
    public ShadowShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setShadow();
    }

    private void setShadow() {
        System.out.println("Adding shadow");
    }
}
