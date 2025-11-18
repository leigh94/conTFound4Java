package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.advanced;

import java.util.*;

// CSV数据处理
public class CSVDataProcessor extends DataProcessorTemplate<Map<String, String>> {

    @Override
    protected List<Map<String, String>> readData(String source) {
        System.out.println("1. 读取CSV文件: " + source);
        List<Map<String, String>> data = new ArrayList<>();

        // 模拟读取CSV数据
        data.add(createRecord("张三", "25", "工程师"));
        data.add(createRecord("李四", "30", "设计师"));
        data.add(createRecord("王五", "28", "产品经理"));

        log("读取到 " + data.size() + " 条记录");
        return data;
    }

    @Override
    protected List<Map<String, String>> transformData(List<Map<String, String>> data) {
        System.out.println("3. 转换数据");
        List<Map<String, String>> transformed = new ArrayList<>();

        for (Map<String, String> record : data) {
            Map<String, String> newRecord = new HashMap<>(record);
            // 添加处理时间戳
            newRecord.put("processed_at", new Date().toString());
            // 转换年龄为整数
            if (newRecord.containsKey("age")) {
                int age = Integer.parseInt(newRecord.get("age"));
                newRecord.put("age_group", getAgeGroup(age));
            }
            transformed.add(newRecord);
        }

        log("数据转换完成");
        return transformed;
    }

    @Override
    protected void processData(List<Map<String, String>> data) {
        System.out.println("4. 处理数据");

        int count = 0;
        for (Map<String, String> record : data) {
            count++;
            logProgress(count, data.size());
            // 模拟处理逻辑
            try {
                Thread.sleep(100); // 模拟处理时间
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 统计信息
        long engineerCount = data.stream()
                .filter(record -> "工程师".equals(record.get("job")))
                .count();
        log("工程师数量: " + engineerCount);
    }

    @Override
    protected void saveResults(List<Map<String, String>> data) {
        System.out.println("5. 保存结果到数据库");
        // 模拟保存到数据库
        log("保存了 " + data.size() + " 条记录");
    }

    @Override
    protected String getProcessName() {
        return "CSV数据处理";
    }

    @Override
    protected boolean needCleanup() {
        return true;
    }

    @Override
    protected void cleanup() {
        System.out.println("6. 清理CSV临时文件");
    }

    // 工具方法
    private Map<String, String> createRecord(String name, String age, String job) {
        Map<String, String> record = new HashMap<>();
        record.put("name", name);
        record.put("age", age);
        record.put("job", job);
        return record;
    }

    private String getAgeGroup(int age) {
        if (age < 25) return "青年";
        else if (age < 35) return "中年";
        else return "资深";
    }
}
