package com.leigh4java.contfound4java.designMode.interpreterPattern.example;

public class VariableExpression implements Expression {
    private String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public boolean interpret(Context context) {
        return context.getVariable(variableName);
    }
}
