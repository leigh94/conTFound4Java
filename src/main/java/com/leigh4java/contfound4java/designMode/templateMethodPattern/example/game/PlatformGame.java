package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.game;

// 平台跳跃游戏实现
public class PlatformGame extends GameLoopTemplate {
    private Character character;
    private int score;
    private int level;

    @Override
    protected void initialize() {
        System.out.println("初始化平台跳跃游戏...");
        character = new Character(0, 0);
        score = 0;
        level = 1;
        log("游戏开始！控制角色跳跃收集金币");
    }

    @Override
    protected void update() {
        // 模拟角色移动和物理更新
        character.update();

        // 随机得分
        if (Math.random() < 0.3) {
            collectCoin();
        }

        // 关卡进度
        if (score >= level * 100) {
            levelUp();
        }
    }

    @Override
    protected void render() {
        if (getFrameCount() % 20 == 0) { // 每20帧渲染一次
            System.out.println("=== 平台游戏状态 ===");
            System.out.println("帧数: " + getFrameCount());
            System.out.println("分数: " + score);
            System.out.println("关卡: " + level);
            System.out.println("角色位置: (" + character.getX() + ", " + character.getY() + ")");
            System.out.println();
        }
    }

    @Override
    protected String getGameName() {
        return "超级跳跃平台";
    }

    @Override
    protected int getTargetFPS() {
        return 120; // 平台游戏需要更高帧率
    }

    // 收集金币
    private void collectCoin() {
        int coinValue = 10 + (level * 5);
        score += coinValue;
        log("收集到金币！+" + coinValue + "分");
    }

    // 升级
    private void levelUp() {
        level++;
        log("升级！当前关卡: " + level);
    }
}
