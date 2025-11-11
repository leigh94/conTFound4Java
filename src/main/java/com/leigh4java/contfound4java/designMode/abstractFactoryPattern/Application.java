package com.leigh4java.contfound4java.designMode.abstractFactoryPattern;

// 应用程序
public class Application {
    private Button button;
    private TextBox textBox;
    private CheckBox checkBox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.textBox = factory.createTextBox();
        this.checkBox = factory.createCheckBox();
    }

    public void render() {
        System.out.println("=== 渲染应用程序界面 ===");
        button.render();
        textBox.render();
        checkBox.render();
        System.out.println();
    }

    public void simulateUserInteraction() {
        System.out.println("=== 模拟用户交互 ===");
        button.onClick();
        textBox.setText("Hello, Abstract Factory!");
        checkBox.setChecked(true);

        // 重新渲染显示状态变化
        button.render();
        textBox.render();
        checkBox.render();
        System.out.println();
    }

    // 获取组件引用（可选）
    public Button getButton() { return button; }
    public TextBox getTextBox() { return textBox; }
    public CheckBox getCheckBox() { return checkBox; }
}