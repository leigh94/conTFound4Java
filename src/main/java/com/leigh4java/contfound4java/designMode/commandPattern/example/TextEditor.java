package com.leigh4java.contfound4java.designMode.commandPattern.example;

import java.util.Stack;

// 文本编辑器 - 调用者
public class TextEditor {
    private Document document;
    private Stack<Command> history;
    private Stack<Command> redoStack;

    public TextEditor(String filename) {
        this.document = new Document(filename);
        this.history = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void write(String text) {
        Command command = new WriteCommand(document, text);
        executeCommand(command);
    }

    public void delete(int length) {
        Command command = new DeleteCommand(document, length);
        executeCommand(command);
    }

    public void insert(String text, int position) {
        Command command = new InsertCommand(document, text, position);
        executeCommand(command);
    }

    private void executeCommand(Command command) {
        command.execute();
        history.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            history.push(command);
        }
    }

    public void print() {
        document.print();
    }

    public void showHistory() {
        System.out.println("=== 操作历史 ===");
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i).getClass().getSimpleName());
        }
    }
}