package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

public class DynamicChainDemo {
    public static void main(String[] args) {
        System.out.println("=== 动态责任链模式演示 ===\n");

        PurchaseRequest[] requests = {
                new PurchaseRequest(3001, "办公文具", 3000),        // 简单采购
                new PurchaseRequest(3002, "技术培训", 25000),       // 需要合同审查
                new PurchaseRequest(3003, "服务器硬件", 80000),     // 需要技术和合同审查
                new PurchaseRequest(3004, "公司年会", 150000),      // 大额，需要合同审查
                new PurchaseRequest(3005, "开发软件", 45000)        // 技术采购
        };

        for (PurchaseRequest request : requests) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("处理请求: " + request);
            System.out.println("构建动态责任链...");

            EnhancedApprover chain = ChainBuilder.buildDynamicChain(request);
            if (chain != null) {
                ProcessResult result = chain.process(request);
                System.out.println("最终结果: " + result);
            } else {
                System.out.println("无法构建处理链");
            }
        }
    }
}
