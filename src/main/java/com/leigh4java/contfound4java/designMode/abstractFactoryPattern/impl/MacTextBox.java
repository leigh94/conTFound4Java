package com.leigh4java.contfound4java.designMode.abstractFactoryPattern.impl;

// Mac文本框
public class MacTextBox implements TextBox {
    private String text = "";

    @Override
    public void render() {
        System.out.println("渲染Mac风格文本框，内容: " + text);
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}