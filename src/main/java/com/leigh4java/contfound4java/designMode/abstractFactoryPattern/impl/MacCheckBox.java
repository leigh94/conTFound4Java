package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl;

import com.leigh4java.contfound4java.designMode.abstractFactoryPattern.CheckBox;

// Mac复选框
public class MacCheckBox implements CheckBox {
    private boolean checked = false;

    @Override
    public void render() {
        System.out.println("渲染Mac风格复选框: " + (checked ? "☑" : "☐"));
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
