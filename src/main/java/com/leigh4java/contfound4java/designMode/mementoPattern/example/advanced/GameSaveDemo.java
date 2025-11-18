package com.leigh4java.contfound4java.designMode.mementoPattern.example.advanced;

public class GameSaveDemo {
    public static void main(String[] args) {
        System.out.println("=== 高级备忘录模式演示 - 游戏存档系统 ===\n");

        // 创建游戏角色和存档管理器
        GameCharacter hero = new GameCharacter("勇者");
        SaveManager saveManager = new SaveManager();

        System.out.println("=== 初始游戏过程 ===");
        hero.displayStatus();

        // 进行一些游戏操作
        hero.gainExperience(100);
        hero.levelUp();
        hero.addItem("治疗药水", 3);
        hero.addItem("魔法卷轴", 1);
        hero.moveTo(new Position(10, 15, "森林"));

        // 保存游戏
        System.out.println("\n=== 第一次保存 ===");
        saveManager.saveGame(hero, "初始冒险");

        // 继续游戏
        System.out.println("\n=== 继续冒险 ===");
        hero.gainExperience(150);
        hero.levelUp();
        hero.takeDamage(30);
        hero.heal(20);
        hero.addItem("黄金", 50);
        hero.moveTo(new Position(25, 40, "城堡"));

        // 再次保存
        System.out.println("\n=== 第二次保存 ===");
        saveManager.saveGame(hero, "城堡探险");

        // 显示当前状态
        System.out.println("\n=== 当前状态 ===");
        hero.displayStatus();

        // 列出所有存档
        System.out.println("\n=== 存档列表 ===");
        saveManager.listSaves();

        // 测试加载存档
        System.out.println("\n=== 加载初始存档 ===");
        saveManager.loadGame(hero, "初始冒险");
        hero.displayStatus();

        // 自动保存测试
        System.out.println("\n=== 自动保存测试 ===");
        saveManager.autoSave(hero);
        saveManager.listSaves();

        // 删除存档测试
        System.out.println("\n=== 删除存档测试 ===");
        saveManager.deleteSave("初始冒险");
        saveManager.listSaves();
    }
}