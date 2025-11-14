package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl;

// Windows复选框
public class WindowsCheckBox implements CheckBox {
    private boolean checked = false;

    @Override
    public void render() {
        System.out.println("渲染Windows风格复选框: " + (checked ? "✓" : "□"));
    }

    @Override
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public boolean isChecked() {
        return checked;
    }
}