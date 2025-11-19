package com.leigh4java.contfound4java.designMode.visitorPattern.example.basics;

import java.util.ArrayList;
import java.util.List;

// 1. 访问者接口
interface ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
}

// 2. 元素接口
interface ComputerPart {
    void accept(ComputerPartVisitor visitor);
}

// 3. 具体元素类
class Computer implements ComputerPart {
    private List<ComputerPart> parts;

    public Computer() {
        parts = new ArrayList<>();
        parts.add(new Mouse());
        parts.add(new Keyboard());
        parts.add(new Monitor());
    }

    @Override
    public void accept(ComputerPartVisitor visitor) {
        for (ComputerPart part : parts) {
            part.accept(visitor);
        }
        visitor.visit(this);
    }
}

class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }

    public String getMouseInfo() {
        return "无线鼠标, 1600DPI";
    }
}

class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }

    public String getKeyboardInfo() {
        return "机械键盘, 青轴";
    }
}

class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }

    public String getMonitorInfo() {
        return "27英寸 4K显示器";
    }
}

// 4. 具体访问者 - 显示访问者
class DisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("显示电脑配置");
        System.out.println("==============");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("鼠标: " + mouse.getMouseInfo());
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("键盘: " + keyboard.getKeyboardInfo());
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("显示器: " + monitor.getMonitorInfo());
    }
}

// 5. 具体访问者 - 诊断访问者
class DiagnosticVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("\n开始电脑诊断...");
        System.out.println("================");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("✓ 鼠标诊断: 连接正常，驱动程序已安装");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("✓ 键盘诊断: 所有按键响应正常");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("✓ 显示器诊断: 分辨率设置正确，无坏点");
    }
}

// 6. 具体访问者 - 价格计算访问者
class PriceCalculationVisitor implements ComputerPartVisitor {
    private double totalPrice = 0;

    @Override
    public void visit(Computer computer) {
        System.out.println("\n电脑部件价格计算");
        System.out.println("=================");
    }

    @Override
    public void visit(Mouse mouse) {
        double price = 199.0;
        System.out.println("鼠标价格: ¥" + price);
        totalPrice += price;
    }

    @Override
    public void visit(Keyboard keyboard) {
        double price = 599.0;
        System.out.println("键盘价格: ¥" + price);
        totalPrice += price;
    }

    @Override
    public void visit(Monitor monitor) {
        double price = 2499.0;
        System.out.println("显示器价格: ¥" + price);
        totalPrice += price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

// 7. 客户端代码
public class VisitorPatternDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();

        System.out.println("=== 访问者模式演示 ===\n");

        // 使用显示访问者
        System.out.println("1. 显示电脑配置:");
        computer.accept(new DisplayVisitor());

        // 使用诊断访问者
        System.out.println("\n2. 系统诊断:");
        computer.accept(new DiagnosticVisitor());

        // 使用价格计算访问者
        PriceCalculationVisitor priceVisitor = new PriceCalculationVisitor();
        computer.accept(priceVisitor);
        System.out.println("\n总价格: ¥" + priceVisitor.getTotalPrice());
    }
}
