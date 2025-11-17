package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

// 经理 - 可以审批 <= 5000 的采购
public class Manager extends Approver {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 5000) {
            System.out.println("经理 " + name + " 审批了 " + request);
        } else if (nextApprover != null) {
            System.out.println("经理 " + name + " 无法审批，转交给上级");
            nextApprover.processRequest(request);
        } else {
            System.out.println("经理 " + name + " 无法审批，且没有更高审批人");
        }
    }
}
