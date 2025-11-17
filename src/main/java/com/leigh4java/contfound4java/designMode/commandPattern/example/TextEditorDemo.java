package com.leigh4java.contfound4java.designMode.commandPattern.example;

public class TextEditorDemo {
    public static void main(String[] args) {
        System.out.println("=== 文本编辑器命令模式演示 ===\n");

        TextEditor editor = new TextEditor("测试文档.txt");

        System.out.println("=== 编辑操作 ===");
        editor.write("Hello, ");
        editor.write("World!");
        editor.insert(" beautiful", 6);
        editor.print();

        System.out.println("=== 撤销操作 ===");
        editor.undo(); // 撤销插入
        editor.undo(); // 撤销写入 "World!"
        editor.print();

        System.out.println("=== 重做操作 ===");
        editor.redo(); // 重做写入 "World!"
        editor.print();

        System.out.println("=== 继续编辑 ===");
        editor.write(" This is a command pattern demo.");
        editor.delete(6); // 删除 "demo."
        editor.print();

        System.out.println("=== 显示历史 ===");
        editor.showHistory();

        System.out.println("=== 多次撤销 ===");
        editor.undo();
        editor.undo();
        editor.undo();
        editor.print();
    }
}