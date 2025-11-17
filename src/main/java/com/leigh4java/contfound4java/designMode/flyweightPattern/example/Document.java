package com.leigh4java.contfound4java.designMode.flyweightPattern.example;

// 文档类
public class Document {
    public static void main(String[] args) {
        System.out.println("=== 文字处理器享元模式演示 ===\n");

        String text = "Hello World!";
        String font = "Arial";
        int size = 12;

        System.out.println("文档内容: " + text);

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Character character = CharacterFactory.getCharacter(c, font, size);
            character.display(i, "黑色");
        }

        // 重复使用相同的字符
        System.out.println("\n=== 重用字符 ===");
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Character character = CharacterFactory.getCharacter(c, font, size);
            character.display(i + 100, "蓝色"); // 不同位置和颜色
        }

        System.out.println("\n字符总数: " + text.length() * 2);
        System.out.println("实际创建的字符对象: " + CharacterFactory.getCharacterCount());
    }
}
