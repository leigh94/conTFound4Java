package com.leigh4java.contfound4java.designMode.mementoPattern.example;

public class BasicMementoDemo {
    public static void main(String[] args) {
        System.out.println("=== 基础备忘录模式演示 - 文本编辑器 ===\n");

        // 创建文本编辑器和历史管理器
        TextEditor editor = new TextEditor("我的文档");
        HistoryManager history = new HistoryManager(5); // 最多保存5个快照

        // 编辑文档并定期保存
        System.out.println("=== 编辑过程 ===");
        editor.write("今天是美好的一天。");
        history.saveMemento(editor.save());

        editor.write(" 阳光明媚，");
        history.saveMemento(editor.save());

        editor.write(" 鸟儿在歌唱。");
        history.saveMemento(editor.save());

        editor.write(" 我决定去公园散步。");
        history.saveMemento(editor.save());

        // 显示当前状态
        System.out.println("\n=== 当前文档状态 ===");
        editor.display();

        // 显示历史
        System.out.println("\n=== 快照历史 ===");
        history.showHistory();

        // 测试撤销功能
        System.out.println("\n=== 撤销操作 ===");
        TextMemento previousState = history.undo();
        if (previousState != null) {
            editor.restore(previousState);
        }

        System.out.println("\n=== 再次撤销 ===");
        previousState = history.undo();
        if (previousState != null) {
            editor.restore(previousState);
        }

        // 显示最终状态和历史
        System.out.println("\n=== 最终状态 ===");
        editor.display();
        history.showHistory();

        // 测试恢复到特定快照
        System.out.println("\n=== 恢复到第一个快照 ===");
        TextMemento firstSnapshot = history.getMemento(0);
        if (firstSnapshot != null) {
            editor.restore(firstSnapshot);
        }
    }
}