package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.basics;

// 具体实现 - 咖啡
public class Coffee extends BeverageTemplate {

    @Override
    protected void brew() {
        System.out.println("2. 冲泡咖啡粉");
    }

    @Override
    protected void addCondiments() {
        System.out.println("4. 加糖和牛奶");
    }

    @Override
    protected String getBeverageName() {
        return "咖啡";
    }

    @Override
    protected void extraStep() {
        System.out.println("4.1 搅拌咖啡");
    }
}
