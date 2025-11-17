package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

// 总监 - 可以审批 <= 10000 的采购
public class Director extends Approver {
    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 10000) {
            System.out.println("总监 " + name + " 审批了 " + request);
        } else if (nextApprover != null) {
            System.out.println("总监 " + name + " 无法审批，转交给上级");
            nextApprover.processRequest(request);
        } else {
            System.out.println("总监 " + name + " 无法审批，且没有更高审批人");
        }
    }
}
