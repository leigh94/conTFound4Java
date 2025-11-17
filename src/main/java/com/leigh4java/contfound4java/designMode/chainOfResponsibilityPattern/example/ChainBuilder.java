package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

import java.util.*;

// 责任链构建器
public class ChainBuilder {
    private List<EnhancedApprover> approvers = new ArrayList<>();

    public ChainBuilder addApprover(EnhancedApprover approver) {
        approvers.add(approver);
        return this;
    }

    public EnhancedApprover build() {
        if (approvers.isEmpty()) {
            return null;
        }

        // 构建链
        for (int i = 0; i < approvers.size() - 1; i++) {
            approvers.get(i).setNextApprover(approvers.get(i + 1));
        }

        return approvers.get(0);
    }

    // 根据条件动态构建链
    public static EnhancedApprover buildDynamicChain(PurchaseRequest request) {
        ChainBuilder builder = new ChainBuilder();

        // 总是需要预算检查
        builder.addApprover(new BudgetChecker("预算部", 200000));

        // 技术相关采购需要技术评审
        if (request.getDescription().matches(".*(服务器|软件|系统|设备|技术).*")) {
            builder.addApprover(new TechnicalReviewer("技术部",
                    Arrays.asList("服务器", "软件", "设备", "系统", "技术")));
        }

        // 大额采购需要合同审查
        if (request.getAmount() > 10000) {
            builder.addApprover(new ContractReviewer("法务部"));
        }

        // 最终审批
        if (request.getAmount() <= 50000) {
            builder.addApprover(new FinalApprover("部门总监", 50000));
        } else {
            builder.addApprover(new FinalApprover("CEO", 200000));
        }

        return builder.build();
    }
}
