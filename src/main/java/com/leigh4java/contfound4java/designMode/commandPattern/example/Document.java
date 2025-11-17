package com.leigh4java.contfound4java.designMode.commandPattern.example;

// 文档类 - 接收者
public class Document {
    private StringBuilder content;
    private String filename;

    public Document(String filename) {
        this.filename = filename;
        this.content = new StringBuilder();
    }

    public void write(String text) {
        content.append(text);
        System.out.println("文档写入: \"" + text + "\"");
    }

    public void delete(int length) {
        if (content.length() >= length) {
            String deleted = content.substring(content.length() - length);
            content.setLength(content.length() - length);
            System.out.println("文档删除: \"" + deleted + "\"");
        }
    }

    public void insert(String text, int position) {
        if (position >= 0 && position <= content.length()) {
            content.insert(position, text);
            System.out.println("文档插入: \"" + text + "\" 在位置 " + position);
        }
    }

    public void print() {
        System.out.println("=== 文档内容: " + filename + " ===");
        System.out.println(content.toString());
        System.out.println("=== 文档结束 ===\n");
    }

    public int getLength() {
        return content.length();
    }

    public String getContent() {
        return content.toString();
    }
}
