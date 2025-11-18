package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.basics;

public class BasicTemplateDemo {
    public static void main(String[] args) {
        System.out.println("=== 基础模板方法模式演示 - 饮料制作 ===\n");

        // 制作茶
        BeverageTemplate tea = new Tea();
        tea.prepareBeverage();

        // 制作咖啡
        BeverageTemplate coffee = new Coffee();
        coffee.prepareBeverage();

        // 制作黑咖啡
        BeverageTemplate blackCoffee = new BlackCoffee();
        blackCoffee.prepareBeverage();

        // 制作热巧克力
        BeverageTemplate hotChocolate = new HotChocolate();
        hotChocolate.prepareBeverage();

        // 测试多态性
        System.out.println("=== 多态性测试 ===");
        BeverageTemplate[] beverages = {
                new Tea(),
                new Coffee(),
                new BlackCoffee(),
                new HotChocolate()
        };

        for (BeverageTemplate beverage : beverages) {
            beverage.prepareBeverage();
        }
    }
}
