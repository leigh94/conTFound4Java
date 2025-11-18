package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.game;

import java.util.*;

// Java项目构建流程
public class JavaBuildProcess extends BuildProcessTemplate {
    private List<String> compiledClasses;
    private boolean testsPassed;

    @Override
    protected void prepare() {
        logStep("准备Java构建环境");
        compiledClasses = new ArrayList<>();
        testsPassed = true;
        logInfo("检查JDK版本...");
        logInfo("创建构建目录...");
    }

    @Override
    protected void resolveDependencies() {
        logStep("解析Maven依赖");
        logInfo("下载依赖包...");
        logInfo("配置类路径...");
    }

    @Override
    protected void compile() {
        logStep("编译Java源代码");
        logInfo("编译主代码...");
        compiledClasses.add("Main.class");
        compiledClasses.add("Utils.class");
        compiledClasses.add("Service.class");
        logInfo("编译了 " + compiledClasses.size() + " 个类文件");
    }

    @Override
    protected void runTests() {
        logStep("运行单元测试");
        logInfo("执行JUnit测试...");
        // 模拟测试结果
        testsPassed = Math.random() > 0.2; // 80%通过率
        if (!testsPassed) {
            throw new BuildException("单元测试失败");
        }
        logInfo("所有测试通过");
    }

    @Override
    protected void runQualityChecks() {
        logStep("运行代码质量检查");
        logInfo("执行Checkstyle检查...");
        logInfo("执行PMD静态分析...");
        logInfo("代码质量检查通过");
    }

    @Override
    protected void packageArtifact() {
        logStep("打包JAR文件");
        logInfo("创建MANIFEST.MF...");
        logInfo("打包类文件...");
        logInfo("生成: target/myapp-1.0.0.jar");
    }

    @Override
    protected void deploy() {
        logStep("部署到服务器");
        logInfo("上传JAR文件...");
        logInfo("重启应用服务...");
        logInfo("部署完成");
    }

    @Override
    protected String getProjectName() {
        return "Java企业应用";
    }

    @Override
    protected boolean shouldRunQualityChecks() {
        return true;
    }

    @Override
    protected boolean shouldDeploy() {
        return true;
    }
}
