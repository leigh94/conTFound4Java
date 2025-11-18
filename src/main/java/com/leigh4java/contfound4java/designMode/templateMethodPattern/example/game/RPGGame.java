package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.game;

import java.util.Random;

// RPG游戏实现
public class RPGGame extends GameLoopTemplate {
    private Player player;
    private Enemy currentEnemy;
    private Random random;
    private int gameState; // 0:探索, 1:战斗

    @Override
    protected void initialize() {
        System.out.println("初始化RPG游戏...");
        player = new Player("勇者", 100, 20);
        random = new Random();
        gameState = 0;
        log("玩家 " + player.getName() + " 开始冒险");
    }

    @Override
    protected void update() {
        switch (gameState) {
            case 0: // 探索状态
                updateExploration();
                break;
            case 1: // 战斗状态
                updateBattle();
                break;
        }
    }

    @Override
    protected void render() {
        if (getFrameCount() % 30 == 0) { // 每30帧渲染一次状态
            System.out.println("=== 游戏状态 ===");
            System.out.println("帧数: " + getFrameCount());
            System.out.println("玩家: " + player);
            if (currentEnemy != null) {
                System.out.println("敌人: " + currentEnemy);
            }
            System.out.println("状态: " + (gameState == 0 ? "探索" : "战斗"));
            System.out.println();
        }
    }

    @Override
    protected String getGameName() {
        return "勇者冒险RPG";
    }

    @Override
    protected long getMaxFrames() {
        return 300; // RPG游戏运行更长时间
    }

    // 探索状态更新
    private void updateExploration() {
        if (random.nextInt(100) < 20) { // 20%几率遇到敌人
            encounterEnemy();
        } else {
            log(player.getName() + " 在探索世界...");
        }
    }

    // 战斗状态更新
    private void updateBattle() {
        if (currentEnemy != null) {
            // 玩家攻击
            int playerDamage = player.attack();
            currentEnemy.takeDamage(playerDamage);
            log(player.getName() + " 对 " + currentEnemy.getName() + " 造成 " + playerDamage + " 点伤害");

            if (currentEnemy.isDefeated()) {
                log("击败了 " + currentEnemy.getName() + "!");
                player.gainExp(currentEnemy.getExpReward());
                currentEnemy = null;
                gameState = 0;
                return;
            }

            // 敌人攻击
            int enemyDamage = currentEnemy.attack();
            player.takeDamage(enemyDamage);
            log(currentEnemy.getName() + " 对 " + player.getName() + " 造成 " + enemyDamage + " 点伤害");

            if (player.isDefeated()) {
                log(player.getName() + " 被击败了!");
                stopGame();
            }
        }
    }

    // 遇到敌人
    private void encounterEnemy() {
        String[] enemyNames = {"哥布林", "骷髅兵", "魔法师", "巨龙"};
        String enemyName = enemyNames[random.nextInt(enemyNames.length)];
        int enemyHp = 30 + random.nextInt(50);
        int enemyAttack = 5 + random.nextInt(15);
        int expReward = 10 + random.nextInt(20);

        currentEnemy = new Enemy(enemyName, enemyHp, enemyAttack, expReward);
        gameState = 1;
        log("遭遇了 " + enemyName + "! 进入战斗状态");
    }
}





class Enemy {
    private String name;
    private int health;
    private int attackPower;
    private int expReward;

    public Enemy(String name, int health, int attackPower, int expReward) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.expReward = expReward;
    }

    public int attack() {
        return attackPower + (int)(Math.random() * 5);
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    // Getters
    public String getName() { return name; }
    public int getExpReward() { return expReward; }

    @Override
    public String toString() {
        return String.format("%s HP:%d ATK:%d", name, health, attackPower);
    }
}

class Character {
    private double x, y;
    private double velocityX, velocityY;

    public Character(double x, double y) {
        this.x = x;
        this.y = y;
        this.velocityX = 2.0;
        this.velocityY = 0;
    }

    public void update() {
        x += velocityX;
        y += velocityY;

        // 简单的重力模拟
        velocityY -= 0.5;

        // 地面碰撞
        if (y < 0) {
            y = 0;
            velocityY = 0;
        }

        // 随机跳跃
        if (Math.random() < 0.1 && y == 0) {
            jump();
        }
    }

    public void jump() {
        velocityY = 10.0;
    }

    // Getters
    public int getX() { return (int)x; }
    public int getY() { return (int)y; }
}
