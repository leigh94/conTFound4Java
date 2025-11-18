package com.leigh4java.contfound4java.designMode.interpreterPattern.example;

public class InterpreterDemo {
    public static void main(String[] args) {
        Context context = new Context();
        context.setVariable("A", true);
        context.setVariable("B", false);
        context.setVariable("C", true);

        // 构建表达式：A AND B
        Expression a = new VariableExpression("A");
        Expression b = new VariableExpression("B");
        Expression andExpr = new AndExpression(a, b);
        System.out.println("A AND B: " + andExpr.interpret(context));

        // 构建表达式：A OR B
        Expression orExpr = new OrExpression(a, b);
        System.out.println("A OR B: " + orExpr.interpret(context));

        // 构建表达式：NOT A
        Expression notExpr = new NotExpression(a);
        System.out.println("NOT A: " + notExpr.interpret(context));

        // 构建复杂表达式：(A AND B) OR C
        Expression andExpr2 = new AndExpression(a, b);
        Expression c = new VariableExpression("C");
        Expression orExpr2 = new OrExpression(andExpr2, c);
        System.out.println("(A AND B) OR C: " + orExpr2.interpret(context));

        // 构建复杂表达式：NOT (A OR B) AND C
        Expression orExpr3 = new OrExpression(a, b);
        Expression notExpr2 = new NotExpression(orExpr3);
        Expression andExpr3 = new AndExpression(notExpr2, c);
        System.out.println("NOT (A OR B) AND C: " + andExpr3.interpret(context));
    }
}
