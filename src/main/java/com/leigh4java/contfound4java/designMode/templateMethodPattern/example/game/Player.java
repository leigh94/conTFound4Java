package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.game;

// 游戏角色类
public class Player {
    private String name;
    private int health;
    private int maxHealth;
    private int attackPower;
    private int experience;
    private int level;

    public Player(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackPower = attackPower;
        this.experience = 0;
        this.level = 1;
    }

    public int attack() {
        return attackPower + (int)(Math.random() * 10);
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public void gainExp(int exp) {
        experience += exp;
        if (experience >= level * 100) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        maxHealth += 20;
        health = maxHealth;
        attackPower += 5;
        System.out.println("🎉 " + name + " 升级了！当前等级: " + level);
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    // Getters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getLevel() { return level; }

    @Override
    public String toString() {
        return String.format("%s Lv.%d HP:%d/%d ATK:%d EXP:%d",
                name, level, health, maxHealth, attackPower, experience);
    }
}
