package com.leigh4java.contfound4java.designMode.chainOfResponsibilityPattern.example;

public class ProcessResult {
    private boolean approved;
    private String message;
    private String approver;

    public ProcessResult(boolean approved, String message, String approver) {
        this.approved = approved;
        this.message = message;
        this.approver = approver;
    }

    // getters
    public boolean isApproved() { return approved; }
    public String getMessage() { return message; }
    public String getApprover() { return approver; }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s",
                approved ? "通过" : "拒绝", approver, message);
    }
}
