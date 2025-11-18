# project task
1. 23种设计模式
    - 创建型
        - 这些模式关注对象的创建机制，旨在以更灵活、更合适的方式创建对象，而不是直接使用 new 关键字
        - [单例模式](singletonPattern/README.md)
        - [工厂方法模式](factoryPattern/README.md)
        - [抽象工厂模式](abstractFactoryPattern/README.md)
        - [建造者模式](builderPattern/README.md)
        - [原型模式](prototypePattern/README.md)
    - 结构型
        - 这些模式关注类和对象的组合，形成更大的结构。它们通过继承和组合，使接口和实现之间建立关联。
        - [适配器模式](adapterPattern/README.md)
        - [桥接模式](bridgePattern/README.md)
        - [组合模式](compositePattern/README.md)
        - [装饰器模式](decoratorPattern/README.md)
        - [外观模式](facadePattern/README.md)
        - [享元模式](flyweightPattern/README.md)
        - [代理模式](proxyPattern/README.md)
    - 行为型
        - 这些模式特别关注对象之间的职责分配和通信
        - [责任链模式](chainOfResponsibilityPattern/README.md)
        - [命令模式](commandPattern/README.md)
        - [解释器模式](interpreterPattern/README.md)
        - [迭代器模式](iteratorPattern/README.md)
        - [中介者模式](mediatorPattern/README.md)
        - [备忘录模式](mementoPattern/README.md)
        - [观察者模式](observerPattern/README.md)
        - [状态模式](statePattern/README.md)
        - [策略模式](strategyPattern/README.md)
        - [模板方法模式]()
        - [访问者模式]()

    1. [单例模式](singletonPattern/README.md)
    - 目的：确保一个类只有一个实例，并提供一个全局访问点。
    - Java 示例：java.lang.Runtime, Spring 容器中的 Bean 默认作用域。
    - 关键点：私有构造函数、静态实例、静态获取方法。
    2. [工厂方法模式](factoryPattern/README.md)
    - 目的：定义一个用于创建对象的接口，但让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。
    - Java 示例：java.util.Calendar#getInstance(), java.text.NumberFormat#getInstance()。
    3. [抽象工厂模式](abstractFactoryPattern/README.md)
    - 目的：提供一个接口，用于创建相关或依赖对象的家族，而不需要指定具体的类。
    - Java 示例：javax.xml.parsers.DocumentBuilderFactory。
    4. [建造者模式](builderPattern/README.md)
    - 目的：将一个复杂对象的构建与其表示分离，使得同样的构建过程可以创建不同的表示。
    - Java 示例：java.lang.StringBuilder, java.lang.StringBuffer, Lombok 的 @Builder 注解。
    5. [原型模式](prototypePattern/README.md)
    - 目的：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
    - Java 示例：实现 Cloneable 接口并重写 clone() 方法。
    6. [适配器模式](adapterPattern/README.md)
        - 目的：将一个类的接口转换成客户希望的另外一个接口。使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
        - Java 示例：java.util.Arrays#asList(), java.io.InputStreamReader(InputStream)。
    7. [桥接模式](bridgePattern/README.md)
        - 目的：将抽象部分与它的实现部分分离，使它们都可以独立地变化。
        - Java 示例：JDBC 驱动程序是桥接模式的经典应用。DriverManager 是抽象层，具体的数据库驱动是实现层。
    8. [组合模式](compositePattern/README.md)
        - 目的：将对象组合成树形结构以表示“部分-整体”的层次结构。使得用户对单个对象和组合对象的使用具有一致性。
        - Java 示例：GUI 中的容器和组件（如 AWT/Swing 中的 Container 和 Component），文件系统（文件和文件夹）。
    9. [装饰器模式](decoratorPattern/README.md)
        - 目的：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
        - Java 示例：java.io 包中的类，如 BufferedReader(Reader in), FileInputStream。
    10. [外观模式](facadePattern/README.md)
        - 目的：为子系统中的一组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
        - Java 示例：SLF4J 是一个日志门面，它背后可以连接 Logback、Log4j2 等具体的日志实现。
    11. [享元模式](flyweightPattern/README.md)
        - 目的：运用共享技术来有效地支持大量细粒度对象的复用。
        - Java 示例：java.lang.String 常量池，Integer.valueOf(int) 的缓存（-128 到 127）。
    12. [代理模式](proxyPattern/README.md)
        - 目的：为其他对象提供一种代理以控制对这个对象的访问。
        - Java 示例：Java 动态代理，Spring AOP 的实现机制。
    13. [责任链模式](chainOfResponsibilityPattern/README.md)
        - 目的：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
        - Java 示例：Java Servlet 中的 FilterChain, java.util.logging.Logger 的 log 方法。
    14. [命令模式](commandPattern/README.md)
        - 目的：将一个请求封装为一个对象，从而使你可以用不同的请求对客户进行参数化，对请求排队或记录请求日志，以及支持可撤销的操作。
        - Java 示例：java.lang.Runnable 是所有线程命令的抽象。GUI 中的菜单项、按钮动作。
    15. [解释器模式](interpreterPattern/README.md)
        - 目的：给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
        - Java 示例：java.util.Pattern（正则表达式），SQL 解析。
    16. [迭代器模式](iteratorPattern/README.md)
        - 目的：提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表示。
        - Java 示例：java.util.Iterator 和 java.util.Enumeration。
    17. [中介者模式](mediatorPattern/README.md)
        - 目的：用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
        - Java 示例：Java GUI 中的 EventQueue，MQ 消息队列。
    18. [备忘录模式](mementoPattern/README.md)
        - 目的：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便以后将该对象恢复到原先保存的状态。
        - Java 示例：java.io.Serializable 序列化机制，游戏存档。
    19. [观察者模式](observerPattern/README.md)
        - 目的：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
        - Java 示例：java.util.Observer 和 java.util.Observable（已过时），java.beans.PropertyChangeListener，以及 RxJava, Reactor 等响应式流库。
    20. [状态模式](statePattern/README.md)
        - 目的：允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类。
        - Java 示例：线程的不同状态（NEW, RUNNABLE, BLOCKED, WAITING等）及其行为转换。
    21. [策略模式](strategyPattern/README.md)
        - 目的：定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。
        - Java 示例：java.util.Comparator 接口，用于定义不同的排序策略。
    22. [模板方法模式]()
        - 目的：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
        - Java 示例：java.io.InputStream 的 read() 方法，javax.servlet.http.HttpServlet 的 doGet(), doPost() 方法。
    23. [访问者模式]()
        - 目的：表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
        - Java 示例：Java 编译器的注解处理器（APT），对抽象语法树进行操作。

