package com.leigh4java.contfound4java.designMode.mementoPattern.example;

import java.util.ArrayList;
import java.util.List;

// 管理者 - 负责保存和管理备忘录
public class HistoryManager {
    private List<TextMemento> history;
    private int maxSize;

    public HistoryManager() {
        this(10); // 默认保存10个快照
    }

    public HistoryManager(int maxSize) {
        this.history = new ArrayList<>();
        this.maxSize = maxSize;
    }

    // 保存快照
    public void saveMemento(TextMemento memento) {
        if (history.size() >= maxSize) {
            history.remove(0); // 移除最旧的快照
        }
        history.add(memento);
        System.out.println("快照已保存，当前快照数量: " + history.size());
    }

    // 获取最近的快照
    public TextMemento getLatestMemento() {
        if (history.isEmpty()) {
            return null;
        }
        return history.get(history.size() - 1);
    }

    // 获取指定索引的快照
    public TextMemento getMemento(int index) {
        if (index < 0 || index >= history.size()) {
            return null;
        }
        return history.get(index);
    }

    // 撤销 - 获取上一个快照
    public TextMemento undo() {
        if (history.size() <= 1) {
            return null; // 没有更早的快照
        }
        // 移除当前状态，返回上一个状态
        history.remove(history.size() - 1);
        return getLatestMemento();
    }

    // 显示历史
    public void showHistory() {
        System.out.println("=== 快照历史 ===");
        if (history.isEmpty()) {
            System.out.println("没有快照");
            return;
        }

        for (int i = 0; i < history.size(); i++) {
            TextMemento memento = history.get(i);
            System.out.println(i + ". " + memento + " - 内容: \"" +
                    memento.getContent().substring(0, Math.min(20, memento.getContent().length())) +
                    (memento.getContent().length() > 20 ? "..." : "") + "\"");
        }
    }

    // 清空历史
    public void clearHistory() {
        history.clear();
        System.out.println("历史已清空");
    }

    public int getHistorySize() {
        return history.size();
    }
}

