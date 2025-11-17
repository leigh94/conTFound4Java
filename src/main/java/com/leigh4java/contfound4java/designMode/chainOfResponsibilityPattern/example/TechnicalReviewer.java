package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

import java.util.ArrayList;
import java.util.List;

// 技术评审处理器
public class TechnicalReviewer extends EnhancedApprover {
    private List<String> supportedCategories;

    public TechnicalReviewer(String name, List<String> supportedCategories) {
        super(name);
        this.supportedCategories = new ArrayList<>(supportedCategories);
    }

    @Override
    public ProcessResult process(PurchaseRequest request) {
        String category = request.getDescription().toLowerCase();
        boolean supported = supportedCategories.stream()
                .anyMatch(cat -> category.contains(cat.toLowerCase()));

        if (!supported) {
            ProcessResult result = new ProcessResult(false,
                    "不支持的技术类别: " + request.getDescription(), name);
            processHistory.add(result);
            return result;
        }

        if (nextApprover != null) {
            ProcessResult result = nextApprover.process(request);
            processHistory.add(result);
            return result;
        }

        ProcessResult result = new ProcessResult(true, "技术评审通过", name);
        processHistory.add(result);
        return result;
    }
}
