package com.leigh4java.contfound4java.designMode.commandPattern.example;

public class InsertCommand implements Command {
    private Document document;
    private String text;
    private int position;

    public InsertCommand(Document document, String text, int position) {
        this.document = document;
        this.text = text;
        this.position = position;
    }

    @Override
    public void execute() {
        document.insert(text, position);
    }

    @Override
    public void undo() {
        // 简化实现：删除插入的文本
        document.delete(text.length());
    }
}
