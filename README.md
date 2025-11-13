# ConTFound4Java
Consolidation of the Foundation


# project task
1. [23种设计模式](src%2Fmain%2Fjava%2Fcom%2Fleigh4java%2Fcontfound4java%2FdesignMode%2FREADME.md)
   - 创建型
     - 这些模式关注对象的创建机制，旨在以更灵活、更合适的方式创建对象，而不是直接使用 new 关键字
     - [单例模式](src/main/java/com/leigh4java/contfound4java/designMode/singletonPattern/README.md)
     - [工厂方法模式](src/main/java/com/leigh4java/contfound4java/designMode/factoryPattern/README.md)
     - [抽象工厂模式](src/main/java/com/leigh4java/contfound4java/designMode/abstractFactoryPattern/README.md)
     - [建造者模式](src/main/java/com/leigh4java/contfound4java/designMode/builderPattern/README.md)
     - [原型模式](src/main/java/com/leigh4java/contfound4java/designMode/prototypePattern/README.md)
   - 结构型
     - 这些模式关注类和对象的组合，形成更大的结构。它们通过继承和组合，使接口和实现之间建立关联。
     - [适配器模式]()
     - [桥接模式]()
     - [组合模式]()
     - [装饰器模式]()
     - [外观模式]()
     - [享元模式]()
     - [代理模式]()
   - 行为型
     - 这些模式特别关注对象之间的职责分配和通信 
     - [责任链模式]()
     - [命令模式]()
     - [解释器模式]()
     - [迭代器模式]()
     - [中介者模式]()
     - [备忘录模式]()
     - [观察者模式]()
     - [状态模式]()
     - [策略模式]()
     - [模板方法模式]()
     - [访问者模式]()



# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.7/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.7/maven-plugin/build-image.html)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.



# project log
- 2025.11.09 Initial commit project 
- 2025.11.12 add designMode


