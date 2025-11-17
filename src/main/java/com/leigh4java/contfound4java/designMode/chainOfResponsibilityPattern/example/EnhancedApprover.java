package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

import java.util.ArrayList;
import java.util.List;

// 增强的抽象处理器
public abstract class EnhancedApprover {
    protected EnhancedApprover nextApprover;
    protected String name;
    protected List<ProcessResult> processHistory = new ArrayList<>();

    public EnhancedApprover(String name) {
        this.name = name;
    }

    public EnhancedApprover setNextApprover(EnhancedApprover nextApprover) {
        this.nextApprover = nextApprover;
        return this.nextApprover;
    }

    // 处理请求并返回结果
    public abstract ProcessResult process(PurchaseRequest request);

    // 获取处理历史
    public List<ProcessResult> getProcessHistory() {
        return new ArrayList<>(processHistory);
    }

    // 清空处理历史
    public void clearHistory() {
        processHistory.clear();
    }
}
