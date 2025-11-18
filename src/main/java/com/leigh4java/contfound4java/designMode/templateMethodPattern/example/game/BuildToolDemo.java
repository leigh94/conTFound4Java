package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.game;

public class BuildToolDemo {
    public static void main(String[] args) {
        System.out.println("=== 模板方法模式演示 - 构建工具 ===\n");

        // Java项目构建
        System.out.println("📦 Java项目构建");
        BuildProcessTemplate javaBuild = new JavaBuildProcess();
        javaBuild.executeBuild();

        // 前端项目构建
        System.out.println("\n📦 前端项目构建");
        BuildProcessTemplate frontendBuild = new FrontendBuildProcess();
        frontendBuild.executeBuild();

        // 移动应用构建
        System.out.println("\n📦 移动应用构建");
        BuildProcessTemplate mobileBuild = new MobileBuildProcess();
        mobileBuild.executeBuild();

        // 测试构建失败情况
        System.out.println("\n📦 测试构建失败情况");
        BuildProcessTemplate failingBuild = new FailingBuildProcess();
        failingBuild.executeBuild();
    }
}

// 测试构建失败的流程
class FailingBuildProcess extends BuildProcessTemplate {

    @Override
    protected void prepare() {
        logStep("准备失败构建");
        logInfo("这一步会成功...");
    }

    @Override
    protected void resolveDependencies() {
        logStep("解析依赖");
        throw new BuildException("依赖解析失败：网络连接超时");
    }

    @Override
    protected void compile() {
        // 不会执行到这里
    }

    @Override
    protected void runTests() {
        // 不会执行到这里
    }

    @Override
    protected void runQualityChecks() {
        // 不会执行到这里
    }

    @Override
    protected void packageArtifact() {
        // 不会执行到这里
    }

    @Override
    protected void deploy() {
        // 不会执行到这里
    }

    @Override
    protected String getProjectName() {
        return "失败测试项目";
    }
}
