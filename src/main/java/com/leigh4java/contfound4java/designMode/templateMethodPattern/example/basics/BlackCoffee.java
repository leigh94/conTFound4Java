package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.basics;

// 具体实现 - 黑咖啡（不加调料）
public class BlackCoffee extends BeverageTemplate {

    @Override
    protected void brew() {
        System.out.println("2. 冲泡咖啡粉");
    }

    @Override
    protected void addCondiments() {
        System.out.println("4. 不加任何调料");
    }

    @Override
    protected String getBeverageName() {
        return "黑咖啡";
    }

    // 重写钩子方法 - 不要调料
    @Override
    protected boolean customerWantsCondiments() {
        return false;
    }
}
