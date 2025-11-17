package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

// 副总裁 - 可以审批 <= 20000 的采购
public class VicePresident extends Approver {
    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 20000) {
            System.out.println("副总裁 " + name + " 审批了 " + request);
        } else if (nextApprover != null) {
            System.out.println("副总裁 " + name + " 无法审批，转交给上级");
            nextApprover.processRequest(request);
        } else {
            System.out.println("副总裁 " + name + " 无法审批，且没有更高审批人");
        }
    }
}
