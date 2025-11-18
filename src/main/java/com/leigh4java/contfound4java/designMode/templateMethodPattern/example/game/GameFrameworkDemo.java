package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.game;

public class GameFrameworkDemo {
    public static void main(String[] args) {
        System.out.println("=== 模板方法模式演示 - 游戏框架 ===\n");

        // 运行RPG游戏
        System.out.println("🎮 启动RPG游戏");
        GameLoopTemplate rpgGame = new RPGGame();
        rpgGame.runGame();

        // 运行平台游戏
        System.out.println("\n🎮 启动平台跳跃游戏");
        GameLoopTemplate platformGame = new PlatformGame();
        platformGame.runGame();

        // 测试自定义游戏
        System.out.println("\n🎮 启动自定义游戏");
        GameLoopTemplate customGame = new CustomGame();
        customGame.runGame();
    }
}

// 自定义游戏实现
class CustomGame extends GameLoopTemplate {
    private int customCounter;

    @Override
    protected void initialize() {
        System.out.println("初始化自定义游戏...");
        customCounter = 0;
    }

    @Override
    protected void update() {
        customCounter++;
        if (customCounter % 10 == 0) {
            log("自定义计数器: " + customCounter);
        }
    }

    @Override
    protected void render() {
        // 简单渲染
        if (getFrameCount() % 15 == 0) {
            System.out.println("自定义游戏 - 帧数: " + getFrameCount() + ", 计数器: " + customCounter);
        }
    }

    @Override
    protected String getGameName() {
        return "自定义演示游戏";
    }

    @Override
    protected int getTargetFPS() {
        return 30; // 自定义帧率
    }
}