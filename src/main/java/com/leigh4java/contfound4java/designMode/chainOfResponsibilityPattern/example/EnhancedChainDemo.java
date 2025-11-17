package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

import java.util.Arrays;

public class EnhancedChainDemo {
    public static void main(String[] args) {
        System.out.println("=== 增强责任链模式演示 ===\n");


        // 创建各种处理器
        EnhancedApprover budgetChecker = new BudgetChecker("预算部门", 100000);
        EnhancedApprover techReviewer = new TechnicalReviewer("技术部门",
                Arrays.asList("服务器", "软件", "设备", "系统"));
        EnhancedApprover contractReviewer = new ContractReviewer("法务部门");
        EnhancedApprover finalApprover = new FinalApprover("CEO", 50000);

        // 构建责任链
        budgetChecker.setNextApprover(techReviewer)
                .setNextApprover(contractReviewer)
                .setNextApprover(finalApprover);

        // 测试不同的采购请求
        PurchaseRequest[] testRequests = {
                new PurchaseRequest(2001, "办公软件许可", 15000),
                new PurchaseRequest(2002, "高性能服务器", 75000),
                new PurchaseRequest(2003, "团队聚餐", 5000),
                new PurchaseRequest(2004, "云服务系统", 120000),
                new PurchaseRequest(2005, "开发设备", 35000)
        };

        for (PurchaseRequest request : testRequests) {
            System.out.println("\n>>> 处理: " + request);
            ProcessResult result = budgetChecker.process(request);
            System.out.println("审批结果: " + result);

            // 显示处理历史
            if (!result.isApproved()) {
                System.out.println("处理历史:");
                budgetChecker.getProcessHistory().forEach(history ->
                        System.out.println("  - " + history));
            }

            // 清空历史记录
            budgetChecker.clearHistory();
        }
    }
}
