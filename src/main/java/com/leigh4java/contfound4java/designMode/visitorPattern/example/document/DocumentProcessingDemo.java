package com.leigh4java.contfound4java.designMode.visitorPattern.example.document;

import java.util.ArrayList;
import java.util.List;

// 文档元素接口
interface DocumentElement {
    void accept(DocumentVisitor visitor);
}

// 具体文档元素
class Paragraph implements DocumentElement {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getWordCount() {
        return text.split("\\s+").length;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}

class Image implements DocumentElement {
    private String fileName;
    private int width;
    private int height;

    public Image(String fileName, int width, int height) {
        this.fileName = fileName;
        this.width = width;
        this.height = height;
    }

    public String getFileName() {
        return fileName;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}

class Table implements DocumentElement {
    private int rows;
    private int columns;
    private String title;

    public Table(String title, int rows, int columns) {
        this.title = title;
        this.rows = rows;
        this.columns = columns;
    }

    public String getTitle() {
        return title;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getCellCount() {
        return rows * columns;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}

// 文档访问者接口
interface DocumentVisitor {
    void visit(Paragraph paragraph);
    void visit(Image image);
    void visit(Table table);
}

// 字数统计访问者
class WordCountVisitor implements DocumentVisitor {
    private int totalWords = 0;

    @Override
    public void visit(Paragraph paragraph) {
        int words = paragraph.getWordCount();
        System.out.println("段落字数: " + words);
        totalWords += words;
    }

    @Override
    public void visit(Image image) {
        System.out.println("图片: " + image.getFileName() + " (不计入字数)");
    }

    @Override
    public void visit(Table table) {
        System.out.println("表格: " + table.getTitle() + " (不计入字数)");
    }

    public int getTotalWords() {
        return totalWords;
    }
}

// 导出访问者
class ExportVisitor implements DocumentVisitor {
    @Override
    public void visit(Paragraph paragraph) {
        System.out.println("[段落] " + paragraph.getText());
    }

    @Override
    public void visit(Image image) {
        System.out.println("[图片] " + image.getFileName() +
                " (" + image.getWidth() + "x" + image.getHeight() + ")");
    }

    @Override
    public void visit(Table table) {
        System.out.println("[表格] " + table.getTitle() +
                " (" + table.getRows() + "x" + table.getColumns() + ")");
    }
}

// 文档类
class Document {
    private List<DocumentElement> elements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public void accept(DocumentVisitor visitor) {
        for (DocumentElement element : elements) {
            element.accept(visitor);
        }
    }
}

// 文档处理演示
class DocumentProcessingDemo {
    public static void main(String[] args) {
        Document document = new Document();

        // 添加文档元素
        document.addElement(new Paragraph("访问者模式是一种行为设计模式，允许你在不修改类的情况下添加新的操作。"));
        document.addElement(new Image("design_pattern.jpg", 800, 600));
        document.addElement(new Paragraph("这种模式将算法与对象结构分离，使得算法可以独立变化。"));
        document.addElement(new Table("性能对比", 3, 4));
        document.addElement(new Paragraph("使用访问者模式可以提高代码的可维护性和可扩展性。"));

        System.out.println("=== 文档导出 ===");
        document.accept(new ExportVisitor());

        System.out.println("\n=== 字数统计 ===");
        WordCountVisitor wordCountVisitor = new WordCountVisitor();
        document.accept(wordCountVisitor);
        System.out.println("总字数: " + wordCountVisitor.getTotalWords());
    }
}
