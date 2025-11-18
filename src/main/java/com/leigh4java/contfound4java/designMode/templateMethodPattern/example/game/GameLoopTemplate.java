package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.game;

// 游戏循环模板
public abstract class GameLoopTemplate {
    private boolean running = false;
    private long frameCount = 0;

    // 模板方法 - 游戏主循环
    public final void runGame() {
        System.out.println("=== 启动游戏: " + getGameName() + " ===");

        initialize();
        running = true;

        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000.0 / getTargetFPS();
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;

            while (delta >= 1) {
                update();
                delta--;
            }

            render();
            frameCount++;

            // 限制帧率
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                stopGame();
            }

            if (shouldStop()) {
                stopGame();
            }
        }

        cleanup();
        System.out.println("游戏结束。总帧数: " + frameCount);
    }

    // 抽象方法 - 必须由子类实现
    protected abstract void initialize();
    protected abstract void update();
    protected abstract void render();
    protected abstract String getGameName();

    // 具体方法
    protected final void stopGame() {
        running = false;
    }

    // 钩子方法 - 子类可以重写
    protected int getTargetFPS() {
        return 60; // 默认60FPS
    }

    protected boolean shouldStop() {
        return frameCount >= getMaxFrames();
    }

    protected long getMaxFrames() {
        return 100; // 默认运行100帧（用于演示）
    }

    protected void cleanup() {
        System.out.println("清理游戏资源...");
    }

    // 工具方法
    protected void log(String message) {
        System.out.println("[游戏日志] " + message);
    }

    protected long getFrameCount() {
        return frameCount;
    }
}
