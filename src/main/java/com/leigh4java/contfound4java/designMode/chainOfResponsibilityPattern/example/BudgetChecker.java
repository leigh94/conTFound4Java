package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

// 预算检查处理器
public class BudgetChecker extends EnhancedApprover {
    private double budgetLimit;

    public BudgetChecker(String name, double budgetLimit) {
        super(name);
        this.budgetLimit = budgetLimit;
    }

    @Override
    public ProcessResult process(PurchaseRequest request) {
        if (request.getAmount() > budgetLimit) {
            ProcessResult result = new ProcessResult(false,
                    "超出预算限制 (预算: ¥" + budgetLimit + ")", name);
            processHistory.add(result);
            return result;
        }

        // 预算检查通过，传递给下一个处理器
        if (nextApprover != null) {
            ProcessResult result = nextApprover.process(request);
            processHistory.add(result);
            return result;
        }

        ProcessResult result = new ProcessResult(true, "预算检查通过", name);
        processHistory.add(result);
        return result;
    }
}
