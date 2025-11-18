package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.advanced;

import java.util.ArrayList;
import java.util.List;

// JSON数据处理
public class JSONDataProcessor extends DataProcessorTemplate<String> {

    @Override
    protected List<String> readData(String source) {
        System.out.println("1. 读取JSON文件: " + source);
        List<String> data = new ArrayList<>();

        // 模拟读取JSON数据
        data.add("{\"name\": \"产品A\", \"price\": 100, \"category\": \"电子\"}");
        data.add("{\"name\": \"产品B\", \"price\": 200, \"category\": \"家居\"}");
        data.add("{\"name\": \"产品C\", \"price\": 150, \"category\": \"服装\"}");

        log("读取到 " + data.size() + " 条JSON记录");
        return data;
    }

    @Override
    protected List<String> transformData(List<String> data) {
        System.out.println("3. 转换JSON数据");
        List<String> transformed = new ArrayList<>();

        for (String json : data) {
            // 模拟JSON转换 - 添加时间戳
            String transformedJson = json.replace("}", ", \"processed\": \"" +
                    System.currentTimeMillis() + "\"}");
            transformed.add(transformedJson);
        }

        log("JSON数据转换完成");
        return transformed;
    }

    @Override
    protected void processData(List<String> data) {
        System.out.println("4. 处理JSON数据");

        int count = 0;
        for (String json : data) {
            count++;
            logProgress(count, data.size());
            // 模拟JSON解析和处理
            if (json.contains("\"price\"")) {
                log("处理价格数据: " + json);
            }
        }
    }

    @Override
    protected void saveResults(List<String> data) {
        System.out.println("5. 保存JSON结果到文件");
        log("保存了 " + data.size() + " 条JSON记录");
    }

    @Override
    protected String getProcessName() {
        return "JSON数据处理";
    }

    // 重写验证方法
    @Override
    protected boolean validateData(List<String> data) {
        System.out.println("2. 验证JSON数据格式");
        for (String json : data) {
            if (!json.trim().startsWith("{") || !json.trim().endsWith("}")) {
                log("无效的JSON格式: " + json);
                return false;
            }
        }
        return true;
    }
}

