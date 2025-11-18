package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.basics;

// 具体实现 - 茶
public class Tea extends BeverageTemplate {

    @Override
    protected void brew() {
        System.out.println("2. 冲泡茶叶");
    }

    @Override
    protected void addCondiments() {
        System.out.println("4. 添加柠檬");
    }

    @Override
    protected String getBeverageName() {
        return "茶";
    }

    // 重写钩子方法
    @Override
    protected boolean customerWantsCondiments() {
        // 询问用户是否要添加调料
        // 这里简单返回true，实际中可以根据用户输入决定
        return true;
    }
}
