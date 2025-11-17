package com.leigh4java.contfound4java.designMode.commandPattern.example;

public class DeleteCommand implements Command {
    private Document document;
    private int length;
    private String deletedText;

    public DeleteCommand(Document document, int length) {
        this.document = document;
        this.length = length;
    }

    @Override
    public void execute() {
        // 保存被删除的文本以便撤销
        String content = document.getContent();
        if (content.length() >= length) {
            deletedText = content.substring(content.length() - length);
        }
        document.delete(length);
    }

    @Override
    public void undo() {
        if (deletedText != null) {
            document.write(deletedText);
        }
    }
}