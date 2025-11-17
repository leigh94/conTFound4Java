package com.leigh4java.contfound4java.designMode.flyweightPattern.example;

import java.util.HashMap;
import java.util.Map;

// 字符工厂
public class CharacterFactory {
    private static Map<String, Character> characterMap = new HashMap<>();

    public static Character getCharacter(char symbol, String font, int size) {
        String key = symbol + "_" + font + "_" + size;
        Character character = characterMap.get(key);

        if (character == null) {
            character = new Character(symbol, font, size);
            characterMap.put(key, character);
            System.out.println("创建新字符: " + key);
        }

        return character;
    }

    public static int getCharacterCount() {
        return characterMap.size();
    }
}
