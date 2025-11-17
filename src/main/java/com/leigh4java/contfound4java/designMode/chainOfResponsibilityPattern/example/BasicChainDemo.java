package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

public class BasicChainDemo {
    public static void main(String[] args) {
        System.out.println("=== 基础责任链模式演示 - 采购审批系统 ===\n");

        // 创建审批链
        Approver manager = new Manager("张经理");
        Approver director = new Director("李总监");
        Approver vp = new VicePresident("王副总裁");
        Approver president = new President("陈总裁");

        // 构建责任链：经理 -> 总监 -> 副总裁 -> 总裁
        manager.setNextApprover(director)
                .setNextApprover(vp)
                .setNextApprover(president);

        // 创建采购请求
        PurchaseRequest[] requests = {
                new PurchaseRequest(1001, "办公用品", 3000),
                new PurchaseRequest(1002, "团队建设", 8000),
                new PurchaseRequest(1003, "服务器设备", 15000),
                new PurchaseRequest(1004, "公司车辆", 45000),
                new PurchaseRequest(1005, "并购项目", 100000)
        };

        // 处理请求
        for (PurchaseRequest request : requests) {
            System.out.println("\n--- 处理采购请求 ---");
            manager.processRequest(request);
        }
    }
}
