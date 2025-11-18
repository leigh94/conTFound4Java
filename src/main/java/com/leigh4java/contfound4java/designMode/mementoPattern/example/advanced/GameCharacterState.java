package com.leigh4java.contfound4java.designMode.mementoPattern.example.advanced;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// 游戏角色状态
public class GameCharacterState implements Serializable {
    private String name;
    private int level;
    private int health;
    private int mana;
    private int experience;
    private Map<String, Integer> inventory;
    private Position position;

    public GameCharacterState(String name, int level, int health, int mana,
                              int experience, Position position) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.mana = mana;
        this.experience = experience;
        this.position = position;
        this.inventory = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(String item, int quantity) {
        int current = inventory.getOrDefault(item, 0);
        if (current <= quantity) {
            inventory.remove(item);
        } else {
            inventory.put(item, current - quantity);
        }
    }

    // getters and setters
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getHealth() { return health; }
    public int getMana() { return mana; }
    public int getExperience() { return experience; }
    public Map<String, Integer> getInventory() { return new HashMap<>(inventory); }
    public Position getPosition() { return position; }

    public void setLevel(int level) { this.level = level; }
    public void setHealth(int health) { this.health = health; }
    public void setMana(int mana) { this.mana = mana; }
    public void setExperience(int experience) { this.experience = experience; }
    public void setPosition(Position position) { this.position = position; }

    @Override
    public String toString() {
        return String.format("%s (Lv.%d) HP:%d MP:%d EXP:%d 位置:%s 物品:%s",
                name, level, health, mana, experience, position, inventory);
    }
}
