package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

// 最终审批处理器
public class FinalApprover extends EnhancedApprover {
    private double approvalLimit;

    public FinalApprover(String name, double approvalLimit) {
        super(name);
        this.approvalLimit = approvalLimit;
    }

    @Override
    public ProcessResult process(PurchaseRequest request) {
        if (request.getAmount() <= approvalLimit) {
            ProcessResult result = new ProcessResult(true,
                    "最终审批通过 (限额: ¥" + approvalLimit + ")", name);
            processHistory.add(result);
            return result;
        } else {
            ProcessResult result = new ProcessResult(false,
                    "超出最终审批限额", name);
            processHistory.add(result);
            return result;
        }
    }
}
