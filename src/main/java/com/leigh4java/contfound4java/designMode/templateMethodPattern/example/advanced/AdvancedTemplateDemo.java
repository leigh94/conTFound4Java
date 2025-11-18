package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.advanced;

import java.util.ArrayList;
import java.util.List;

public class AdvancedTemplateDemo {
    public static void main(String[] args) {
        System.out.println("=== 高级模板方法模式演示 - 数据处理流程 ===\n");

        // 处理CSV数据
        DataProcessorTemplate<?> csvProcessor = new CSVDataProcessor();
        csvProcessor.processData("data.csv");

        // 处理JSON数据
        DataProcessorTemplate<?> jsonProcessor = new JSONDataProcessor();
        jsonProcessor.processData("data.json");

        // 处理数据库数据
        DataProcessorTemplate<?> dbProcessor = new DatabaseDataProcessor();
        dbProcessor.processData("orders_table");

        // 测试错误情况
        System.out.println("=== 测试错误处理 ===");
        DataProcessorTemplate<?> errorProcessor = new ErrorDataProcessor();
        errorProcessor.processData("invalid_source");
    }
}

// 测试错误处理的数据处理器
class ErrorDataProcessor extends DataProcessorTemplate<String> {

    @Override
    protected List<String> readData(String source) {
        System.out.println("1. 读取数据（模拟空数据）");
        return new ArrayList<>(); // 返回空数据
    }

    @Override
    protected List<String> transformData(List<String> data) {
        return data;
    }

    @Override
    protected void processData(List<String> data) {
        // 空实现
    }

    @Override
    protected void saveResults(List<String> data) {
        // 空实现
    }

    @Override
    protected String getProcessName() {
        return "错误处理测试";
    }
}
