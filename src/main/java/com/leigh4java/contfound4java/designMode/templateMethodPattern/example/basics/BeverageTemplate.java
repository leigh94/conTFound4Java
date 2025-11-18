package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.basics;

// 抽象模板类 - 饮料制作过程
public abstract class BeverageTemplate {

    // 模板方法 - 定义算法骨架 (final防止子类重写)
    public final void prepareBeverage() {
        System.out.println("=== 开始制作 " + getBeverageName() + " ===");
        boilWater();
        brew();
        pourInCup();
        addCondiments();
        if (customerWantsCondiments()) {
            extraStep();
        }
        complete();
    }

    // 具体方法 - 共通的步骤
    private void boilWater() {
        System.out.println("1. 煮沸水");
    }

    private void pourInCup() {
        System.out.println("3. 倒入杯子");
    }

    private void complete() {
        System.out.println("5. " + getBeverageName() + " 制作完成！\n");
    }

    // 抽象方法 - 由子类实现
    protected abstract void brew();
    protected abstract void addCondiments();

    // 钩子方法 - 子类可以选择性重写
    protected boolean customerWantsCondiments() {
        return true;
    }

    protected void extraStep() {
        // 默认空实现
    }

    // 获取饮料名称
    protected abstract String getBeverageName();
}
