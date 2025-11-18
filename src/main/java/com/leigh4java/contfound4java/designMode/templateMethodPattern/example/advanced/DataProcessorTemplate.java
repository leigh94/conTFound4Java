package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.advanced;

import java.util.List;
import java.util.ArrayList;

// 数据处理模板
public abstract class DataProcessorTemplate<T> {

    // 模板方法 - 完整的数据处理流程
    public final void processData(String source) {
        System.out.println("=== 开始处理数据: " + getProcessName() + " ===");

        // 1. 读取数据
        List<T> data = readData(source);
        if (data.isEmpty()) {
            System.out.println("警告: 没有读取到数据");
            return;
        }

        // 2. 验证数据
        if (validateData(data)) {
            System.out.println("数据验证通过");

            // 3. 转换数据
            List<T> transformedData = transformData(data);

            // 4. 处理数据
            processData(transformedData);

            // 5. 保存结果
            saveResults(transformedData);

            // 6. 清理临时数据
            if (needCleanup()) {
                cleanup();
            }

            complete();
        } else {
            handleValidationError(data);
        }
    }

    // 抽象方法 - 必须由子类实现
    protected abstract List<T> readData(String source);
    protected abstract List<T> transformData(List<T> data);
    protected abstract void processData(List<T> data);
    protected abstract void saveResults(List<T> data);

    // 具体方法 - 提供默认实现
    protected boolean validateData(List<T> data) {
        System.out.println("执行基本数据验证...");
        return data != null && !data.isEmpty();
    }

    protected void handleValidationError(List<T> data) {
        System.out.println("数据验证失败，停止处理");
    }

    protected void complete() {
        System.out.println("数据处理完成: " + getProcessName());
    }

    // 钩子方法 - 子类可以选择性重写
    protected boolean needCleanup() {
        return false;
    }

    protected void cleanup() {
        System.out.println("清理临时数据...");
    }

    protected abstract String getProcessName();

    // 工具方法
    protected void log(String message) {
        System.out.println("[日志] " + message);
    }

    protected void logProgress(int current, int total) {
        double progress = (double) current / total * 100;
        System.out.printf("进度: %d/%d (%.1f%%)%n", current, total, progress);
    }
}
