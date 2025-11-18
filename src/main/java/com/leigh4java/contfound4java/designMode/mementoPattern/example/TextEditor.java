package com.leigh4java.contfound4java.designMode.mementoPattern.example;

// 原发器 - 文本编辑器
public class TextEditor {
    private String content;
    private String title;

    public TextEditor(String title) {
        this.title = title;
        this.content = "";
    }

    // 写入内容
    public void write(String text) {
        this.content += text;
        System.out.println("写入: \"" + text + "\"");
        System.out.println("当前内容: " + content);
    }

    // 创建备忘录
    public TextMemento save() {
        System.out.println("创建快照: " + content);
        return new TextMemento(content);
    }

    // 从备忘录恢复
    public void restore(TextMemento memento) {
        this.content = memento.getContent();
        System.out.println("恢复到: " + memento);
        System.out.println("恢复后内容: " + content);
    }

    // 显示当前状态
    public void display() {
        System.out.println("=== " + title + " ===");
        System.out.println("内容: " + content);
        System.out.println("长度: " + content.length() + " 字符");
    }

    // getters
    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
