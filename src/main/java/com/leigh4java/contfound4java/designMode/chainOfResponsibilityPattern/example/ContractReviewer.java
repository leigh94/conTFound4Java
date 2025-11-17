package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

// 合同审查处理器
public class ContractReviewer extends EnhancedApprover {
    public ContractReviewer(String name) {
        super(name);
    }

    @Override
    public ProcessResult process(PurchaseRequest request) {
        // 模拟合同审查逻辑
        if (request.getAmount() > 50000) {
            ProcessResult result = new ProcessResult(false,
                    "大额合同需要法律部门审核", name);
            processHistory.add(result);
            return result;
        }

        if (nextApprover != null) {
            ProcessResult result = nextApprover.process(request);
            processHistory.add(result);
            return result;
        }

        ProcessResult result = new ProcessResult(true, "合同审查通过", name);
        processHistory.add(result);
        return result;
    }
}
