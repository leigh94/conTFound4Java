package com.leigh4java.contfound4java.designMode.visitorPattern.example.compiler;

import java.util.ArrayList;
import java.util.List;

// 抽象语法树节点接口
interface ASTNode {
    void accept(ASTVisitor visitor);
}

// 具体节点类
class VariableNode implements ASTNode {
    private String name;

    public VariableNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

class AssignmentNode implements ASTNode {
    private VariableNode variable;
    private ASTNode expression;

    public AssignmentNode(VariableNode variable, ASTNode expression) {
        this.variable = variable;
        this.expression = expression;
    }

    public VariableNode getVariable() {
        return variable;
    }

    public ASTNode getExpression() {
        return expression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

class BinaryOperationNode implements ASTNode {
    private String operator;
    private ASTNode left;
    private ASTNode right;

    public BinaryOperationNode(String operator, ASTNode left, ASTNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() {
        return operator;
    }

    public ASTNode getLeft() {
        return left;
    }

    public ASTNode getRight() {
        return right;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

class NumberNode implements ASTNode {
    private int value;

    public NumberNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

// AST访问者接口
interface ASTVisitor {
    void visit(VariableNode node);
    void visit(AssignmentNode node);
    void visit(BinaryOperationNode node);
    void visit(NumberNode node);
}

// 代码生成访问者
class CodeGenerationVisitor implements ASTVisitor {
    @Override
    public void visit(VariableNode node) {
        System.out.print(node.getName());
    }

    @Override
    public void visit(AssignmentNode node) {
        node.getVariable().accept(this);
        System.out.print(" = ");
        node.getExpression().accept(this);
        System.out.println(";");
    }

    @Override
    public void visit(BinaryOperationNode node) {
        System.out.print("(");
        node.getLeft().accept(this);
        System.out.print(" " + node.getOperator() + " ");
        node.getRight().accept(this);
        System.out.print(")");
    }

    @Override
    public void visit(NumberNode node) {
        System.out.print(node.getValue());
    }
}

// 类型检查访问者
class TypeCheckingVisitor implements ASTVisitor {
    @Override
    public void visit(VariableNode node) {
        System.out.println("检查变量: " + node.getName());
    }

    @Override
    public void visit(AssignmentNode node) {
        System.out.println("检查赋值语句:");
        node.getVariable().accept(this);
        node.getExpression().accept(this);
    }

    @Override
    public void visit(BinaryOperationNode node) {
        System.out.println("检查二元操作: " + node.getOperator());
        node.getLeft().accept(this);
        node.getRight().accept(this);
    }

    @Override
    public void visit(NumberNode node) {
        System.out.println("检查数字: " + node.getValue());
    }
}

// 优化访问者
class OptimizationVisitor implements ASTVisitor {
    @Override
    public void visit(VariableNode node) {
        System.out.println("优化变量访问: " + node.getName());
    }

    @Override
    public void visit(AssignmentNode node) {
        System.out.println("优化赋值操作");
        node.getVariable().accept(this);
        node.getExpression().accept(this);
    }

    @Override
    public void visit(BinaryOperationNode node) {
        System.out.println("优化二元操作: " + node.getOperator());
        // 常量折叠优化
        if (node.getLeft() instanceof NumberNode && node.getRight() instanceof NumberNode) {
            NumberNode left = (NumberNode) node.getLeft();
            NumberNode right = (NumberNode) node.getRight();
            int result = calculate(left.getValue(), right.getValue(), node.getOperator());
            System.out.println("常量折叠: " + left.getValue() + " " + node.getOperator() +
                    " " + right.getValue() + " = " + result);
        } else {
            node.getLeft().accept(this);
            node.getRight().accept(this);
        }
    }

    @Override
    public void visit(NumberNode node) {
        // 数字节点不需要优化
    }

    private int calculate(int left, int right, String operator) {
        switch (operator) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": return left / right;
            default: return 0;
        }
    }
}

// 编译器演示
class CompilerDemo {
    public static void main(String[] args) {
        // 构建 AST: x = (10 + 5) * 2
        ASTNode ast = new AssignmentNode(
                new VariableNode("x"),
                new BinaryOperationNode("*",
                        new BinaryOperationNode("+",
                                new NumberNode(10),
                                new NumberNode(5)
                        ),
                        new NumberNode(2)
                )
        );

        System.out.println("=== 代码生成 ===");
        CodeGenerationVisitor codeGen = new CodeGenerationVisitor();
        ast.accept(codeGen);

        System.out.println("\n=== 类型检查 ===");
        TypeCheckingVisitor typeChecker = new TypeCheckingVisitor();
        ast.accept(typeChecker);

        System.out.println("\n=== 代码优化 ===");
        OptimizationVisitor optimizer = new OptimizationVisitor();
        ast.accept(optimizer);
    }
}
