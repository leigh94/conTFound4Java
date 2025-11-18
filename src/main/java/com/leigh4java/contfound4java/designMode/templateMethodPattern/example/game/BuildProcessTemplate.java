package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.game;

import java.util.*;

// 构建流程模板
public abstract class BuildProcessTemplate {

    // 模板方法 - 完整的构建流程
    public final void executeBuild() {
        System.out.println("🚀 开始执行构建流程: " + getProjectName());

        long startTime = System.currentTimeMillis();

        try {
            // 1. 准备阶段
            prepare();

            // 2. 依赖处理
            resolveDependencies();

            // 3. 编译
            compile();

            // 4. 测试
            if (shouldRunTests()) {
                runTests();
            }

            // 5. 代码质量检查
            if (shouldRunQualityChecks()) {
                runQualityChecks();
            }

            // 6. 打包
            packageArtifact();

            // 7. 部署
            if (shouldDeploy()) {
                deploy();
            }

            // 8. 完成
            long endTime = System.currentTimeMillis();
            completeBuild(startTime, endTime);

        } catch (BuildException e) {
            handleBuildFailure(e);
        } finally {
            cleanup();
        }
    }

    // 抽象方法
    protected abstract void prepare();
    protected abstract void resolveDependencies();
    protected abstract void compile();
    protected abstract void runTests();
    protected abstract void runQualityChecks();
    protected abstract void packageArtifact();
    protected abstract void deploy();

    // 具体方法
    protected final void completeBuild(long startTime, long endTime) {
        long duration = endTime - startTime;
        System.out.println("✅ 构建成功: " + getProjectName());
        System.out.println("⏱️  构建耗时: " + duration + "ms");
        generateBuildReport();
    }

    protected final void handleBuildFailure(BuildException e) {
        System.out.println("❌ 构建失败: " + e.getMessage());
        notifyBuildFailure(e);
        rollback();
    }

    protected final void generateBuildReport() {
        System.out.println("📊 生成构建报告...");
    }

    protected final void notifyBuildFailure(BuildException e) {
        System.out.println("📧 发送构建失败通知...");
    }

    // 钩子方法
    protected boolean shouldRunTests() {
        return true;
    }

    protected boolean shouldRunQualityChecks() {
        return false;
    }

    protected boolean shouldDeploy() {
        return false;
    }

    protected void rollback() {
        // 默认空实现
    }

    protected void cleanup() {
        System.out.println("🧹 清理构建临时文件...");
    }

    protected abstract String getProjectName();

    // 工具方法
    protected void logStep(String stepName) {
        System.out.println("🔧 执行步骤: " + stepName);
    }

    protected void logInfo(String message) {
        System.out.println("[构建信息] " + message);
    }
}

// 构建异常
class BuildException extends RuntimeException {
    public BuildException(String message) {
        super(message);
    }
}
