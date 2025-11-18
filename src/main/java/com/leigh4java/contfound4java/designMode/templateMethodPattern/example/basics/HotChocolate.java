package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.basics;

// 具体实现 - 热巧克力
public class HotChocolate extends BeverageTemplate {

    @Override
    protected void brew() {
        System.out.println("2. 溶解巧克力粉");
    }

    @Override
    protected void addCondiments() {
        System.out.println("4. 添加棉花糖");
    }

    @Override
    protected String getBeverageName() {
        return "热巧克力";
    }

    @Override
    protected void extraStep() {
        System.out.println("4.1 撒上可可粉");
    }
}
