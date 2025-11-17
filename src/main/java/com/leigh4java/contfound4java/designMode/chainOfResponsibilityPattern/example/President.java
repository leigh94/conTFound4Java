package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

// 总裁 - 可以审批所有采购
public class President extends Approver {
    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 50000) {
            System.out.println("总裁 " + name + " 审批了 " + request);
        } else {
            System.out.println("总裁 " + name + " 需要召开董事会讨论: " + request);
        }
    }
}
