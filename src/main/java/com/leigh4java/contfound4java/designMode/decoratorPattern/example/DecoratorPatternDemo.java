package com.leigh4java.contfound4java.designMode.decoratorPattern.example;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        System.out.println("----------");

        Shape redCircle = new RedShapeDecorator(new Circle());
        redCircle.draw();
        System.out.println("----------");

        Shape shadowCircle = new ShadowShapeDecorator(new Circle());
        shadowCircle.draw();
        System.out.println("----------");

        // 组合使用装饰器
        Shape redShadowCircle = new RedShapeDecorator(new ShadowShapeDecorator(new Circle()));
        redShadowCircle.draw();
    }
}
