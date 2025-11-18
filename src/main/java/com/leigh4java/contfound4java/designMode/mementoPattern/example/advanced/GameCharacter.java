package com.leigh4java.contfound4java.designMode.mementoPattern.example.advanced;

import com.leigh4java.contfound4java.designMode.mementoPattern.example.advanced.Position;

// 游戏角色 - 原发器
public class GameCharacter {
    private GameCharacterState state;

    public GameCharacter(String name) {
        this.state = new GameCharacterState(name, 1, 100, 50, 0, new Position(0, 0, "新手村"));
    }

    // 游戏操作
    public void levelUp() {
        state.setLevel(state.getLevel() + 1);
        state.setHealth(state.getHealth() + 20);
        state.setMana(state.getMana() + 10);
        System.out.println(state.getName() + " 升级了！当前等级: " + state.getLevel());
    }

    public void gainExperience(int exp) {
        state.setExperience(state.getExperience() + exp);
        System.out.println(state.getName() + " 获得 " + exp + " 经验值");
    }

    public void takeDamage(int damage) {
        state.setHealth(Math.max(0, state.getHealth() - damage));
        System.out.println(state.getName() + " 受到 " + damage + " 点伤害，剩余生命: " + state.getHealth());
    }

    public void heal(int amount) {
        state.setHealth(state.getHealth() + amount);
        System.out.println(state.getName() + " 恢复 " + amount + " 点生命，当前生命: " + state.getHealth());
    }

    public void moveTo(Position newPosition) {
        state.setPosition(newPosition);
        System.out.println(state.getName() + " 移动到 " + newPosition);
    }

    public void addItem(String item, int quantity) {
        state.addItem(item, quantity);
        System.out.println("获得物品: " + item + " x" + quantity);
    }

    // 创建存档
    public GameSaveMemento saveGame(String saveName) {
        System.out.println("创建存档: " + saveName);
        return new GameSaveMemento(state, saveName);
    }

    // 加载存档
    public void loadGame(GameSaveMemento memento) {
        this.state = memento.getCharacterState();
        System.out.println("加载存档: " + memento.getSaveName());
    }

    // 显示状态
    public void displayStatus() {
        System.out.println("=== 角色状态 ===");
        System.out.println(state);
    }

    public GameCharacterState getState() {
        return state;
    }
}
