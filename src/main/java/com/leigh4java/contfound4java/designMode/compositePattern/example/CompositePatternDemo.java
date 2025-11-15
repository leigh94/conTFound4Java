package com.leigh4java.contfound4java.designMode.compositePattern.example;

public class CompositePatternDemo {
    public static void main(String[] args) {
        Manager root = new Manager("Head Manager");

        Employee emp1 = new Employee("Employee 1");
        Employee emp2 = new Employee("Employee 2");
        root.add(emp1);
        root.add(emp2);

        Manager manager1 = new Manager("Manager A");
        manager1.add(new Employee("Employee A1"));
        manager1.add(new Employee("Employee A2"));

        Manager manager2 = new Manager("Manager B");
        manager2.add(new Employee("Employee B1"));

        root.add(manager1);
        root.add(manager2);

        // 展示树状结构
        root.display(1);
    }
}
