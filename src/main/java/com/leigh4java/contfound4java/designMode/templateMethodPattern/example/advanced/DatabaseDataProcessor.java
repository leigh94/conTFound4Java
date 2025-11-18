package com.leigh4java.contfound4java.designMode.templateMethodPattern.example.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// 数据库数据处理
public class DatabaseDataProcessor extends DataProcessorTemplate<Object[]> {

    @Override
    protected List<Object[]> readData(String source) {
        System.out.println("1. 从数据库读取数据: " + source);
        List<Object[]> data = new ArrayList<>();

        // 模拟数据库查询结果
        data.add(new Object[]{"订单001", new Date(), 199.99, "已完成"});
        data.add(new Object[]{"订单002", new Date(), 299.99, "处理中"});
        data.add(new Object[]{"订单003", new Date(), 99.99, "已取消"});

        log("从数据库读取到 " + data.size() + " 条记录");
        return data;
    }

    @Override
    protected List<Object[]> transformData(List<Object[]> data) {
        System.out.println("3. 转换数据库数据");
        List<Object[]> transformed = new ArrayList<>();

        for (Object[] record : data) {
            // 添加处理标记
            Object[] newRecord = Arrays.copyOf(record, record.length + 1);
            newRecord[newRecord.length - 1] = "PROCESSED";
            transformed.add(newRecord);
        }

        return transformed;
    }

    @Override
    protected void processData(List<Object[]> data) {
        System.out.println("4. 处理数据库记录");

        double totalAmount = 0;
        int completedOrders = 0;

        for (Object[] record : data) {
            if (record.length >= 4 && record[3].equals("已完成")) {
                completedOrders++;
                if (record[2] instanceof Double) {
                    totalAmount += (Double) record[2];
                }
            }
        }

        log("已完成订单: " + completedOrders);
        log("总金额: " + totalAmount);
    }

    @Override
    protected void saveResults(List<Object[]> data) {
        System.out.println("5. 更新数据库记录");
        log("更新了 " + data.size() + " 条数据库记录");
    }

    @Override
    protected String getProcessName() {
        return "数据库数据处理";
    }

    @Override
    protected boolean needCleanup() {
        return true;
    }

    @Override
    protected void cleanup() {
        System.out.println("6. 关闭数据库连接");
    }
}
