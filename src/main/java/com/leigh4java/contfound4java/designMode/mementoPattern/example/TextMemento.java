package com.leigh4java.contfound4java.designMode.mementoPattern.example;

// 备忘录 - 保存文本编辑器的状态
public class TextMemento {
    private final String content;
    private final long timestamp;

    public TextMemento(String content) {
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "快照 [" + new java.util.Date(timestamp) + "]";
    }
}
