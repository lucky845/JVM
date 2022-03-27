不知道为什么图片无法显示（[我的笔记](https://www.yuque.com/u1447545564/cdxd5w/mghvow)）
## JVM虚拟机架构图

### ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648197704119-bd67e348-bcaf-444e-8726-ce5066291eaa.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=352&id=u5a497e85&margin=%5Bobject%20Object%5D&name=image.png&originHeight=352&originWidth=391&originalType=binary&ratio=1&rotation=0&showTitle=false&size=90937&status=done&style=none&taskId=u96db8be4-5527-4317-9366-d83cc5eb691&title=&width=391)

## 一、类加载器(类加载子系统)

![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198089384-ae249c18-5731-4300-abf9-ec547e2a6c71.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=458&id=u147009a4&margin=%5Bobject%20Object%5D&name=image.png&originHeight=458&originWidth=933&originalType=binary&ratio=1&rotation=0&showTitle=false&size=179965&status=done&style=none&taskId=u2068de4f-9ccf-4441-8c12-f8c4dc7acd4&title=&width=933)

### 1、作用

负责把class字节码文件加载到内存中<br />![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198119138-a1b2d99a-f221-4d2e-8daa-43882de4d51d.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=390&id=u01066cd0&margin=%5Bobject%20Object%5D&name=image.png&originHeight=390&originWidth=938&originalType=binary&ratio=1&rotation=0&showTitle=false&size=188397&status=done&style=none&taskId=u21a9a8c9-cba8-4837-b2d0-a38f8acd726&title=&width=938)

### 2、类加载过程

#### a. 加载

- 通过一个类的全限定类名获取此类的二进制字节流
- 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构
- 在内存中生成一个代表这个类的java.lang.Class对象，作为方法区中这个类的各种数据的访问入口
- 使用IDEA插件 jclasslib-bytecode-viewer 可以查看
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198053353-a076e379-2f51-4925-a327-3da4863473b2.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=153&id=u4a7f138a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=153&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=65740&status=done&style=none&taskId=ubbb86591-acf1-4ee8-bd46-55656c67d9f&title=&width=554)

#### b. 连接

- **验证**
    - 保证加载类的正确性
- **准备**
    - 为类变量分配内存，设置变量的初始值
- **解析**
    - 相当于翻译的过程
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198152144-a5e68dc5-ddc2-49e9-b0c1-e1495372804b.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=280&id=ued666953&margin=%5Bobject%20Object%5D&name=image.png&originHeight=280&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=159105&status=done&style=none&taskId=u8b5577e7-89c1-4602-9f50-b04dfe67d74&title=&width=553)

#### c. 初始化

- 初始化阶段就是执行类构造器方法<clinit>()的过程
- 收集静态变量赋值和静态代码块中的语句合并而来
- <clinit>()不同于类的构造器
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198272829-2d12792c-04e1-4ff9-ba0e-07d92bc923c3.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=211&id=u0cb6e42f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=211&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=101499&status=done&style=none&taskId=u7d070f1e-0deb-42b3-bcaa-40548da6f17&title=&width=554)

### 3、类加载器的分类 （重点）

#### a. 概念

- **引导类加载器和自定义加载器**
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198420801-93b3fd00-7c6f-4d7f-bca5-f58d295ae0d3.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=194&id=u4cc3a995&margin=%5Bobject%20Object%5D&name=image.png&originHeight=194&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=69478&status=done&style=none&taskId=u7af791b6-6c22-4dad-aed7-fcc08015171&title=&width=554)
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198432720-2bb08c54-e802-4856-b771-6e59951fcd7c.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=323&id=u425647b9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=323&originWidth=453&originalType=binary&ratio=1&rotation=0&showTitle=false&size=62810&status=done&style=none&taskId=uf91af986-9534-4478-b64c-7d3f812cba3&title=&width=453)

#### b. 虚拟机自带的类加载器

- **启动类加载器**
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198466336-a52233fb-1de4-405c-b9b9-03509ea73964.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=281&id=uf6c24fca&margin=%5Bobject%20Object%5D&name=image.png&originHeight=281&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=57713&status=done&style=none&taskId=ubd689b63-4957-4a49-a936-6cacd9ae2f7&title=&width=554)
- **扩展类加载器**
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198473724-3291da01-e69e-48e7-9758-463b98cff40e.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=255&id=ua9079ebc&margin=%5Bobject%20Object%5D&name=image.png&originHeight=255&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=48554&status=done&style=none&taskId=u644bf822-8592-4fb2-a45c-5b9a1dc0bcf&title=&width=553)
- **应用程序类加载器**
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198484661-c27d3893-7151-4cf9-8ac4-1e6584a16add.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=293&id=u6a088288&margin=%5Bobject%20Object%5D&name=image.png&originHeight=293&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=69119&status=done&style=none&taskId=uc15f3473-7c68-4736-bba0-b726b6bf788&title=&width=553)

#### c. 类加载规则

- 自己写的类--应用程序类加载器
- JDK核心库--启动类加载器

---

- 用户自定义类加载器实现步骤
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198545547-0657e000-7333-4245-a077-7d808e8564ba.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=250&id=ub995ed75&margin=%5Bobject%20Object%5D&name=image.png&originHeight=250&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=70529&status=done&style=none&taskId=u7ac5e2f4-b35b-4273-91fa-04211501e80&title=&width=554)

### 4、双亲委派模型（面试）

![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648199034920-f83139de-33d0-4abd-ac67-080ca7f56db6.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=159&id=ubae02906&margin=%5Bobject%20Object%5D&name=image.png&originHeight=159&originWidth=842&originalType=binary&ratio=1&rotation=0&showTitle=false&size=89268&status=done&style=none&taskId=u3dfc8b3f-2696-45ed-aa8e-31173115498&title=&width=842)

#### a. 概念

- 要加载类，先坑爹（向上委托）一层一层往上找
- 直到找到顶部启动类加载器，如果启动类加载器能加载，就直接加载
- 如果不能再往下找，坑爹失败
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198840267-62178566-d40c-4eea-a12f-e6b016822f83.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=262&id=u95963cff&margin=%5Bobject%20Object%5D&name=image.png&originHeight=262&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=115664&status=done&style=none&taskId=u196505df-79b1-4e45-927f-9f497f6e9d3&title=&width=554)
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648198862661-d5c6fa7d-2659-4244-aeb0-2e154fd5a17d.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=437&id=u55f08801&margin=%5Bobject%20Object%5D&name=image.png&originHeight=437&originWidth=454&originalType=binary&ratio=1&rotation=0&showTitle=false&size=98448&status=done&style=none&taskId=u1df357f2-5516-446e-87e5-d6e89a3967c&title=&width=454)

#### b. 是否可以自己编写一个String类

- 不能自己编写一个String类，并且在java核心类的包下编写会出现 SecurityException: Prohibited package name: java.lang
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648199600734-1b58d5cc-b30b-468c-9db6-a70a82399e94.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=214&id=u2d684c78&margin=%5Bobject%20Object%5D&name=image.png&originHeight=214&originWidth=917&originalType=binary&ratio=1&rotation=0&showTitle=false&size=124363&status=done&style=none&taskId=ue9b328e0-99ce-422f-aea9-36c16276db5&title=&width=917)

#### c. 沙箱安全机制

- 我们如果要编写和核心类库全限定名一模一样的类，JDK为了保证核心代码的安全，阻止你的代码使用和它全限定名相同的命名
- 保护原生JDK的安全

#### d. 优点

- 避免类的重复加载
- 保护程序安全，防止核心API被随意篡改
    - 自定义类 java.lang.String
    - 自定义类 java.lang.Shkstart
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648199837538-812a0954-725d-4caa-ba17-2de1401e6801.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=37&id=u84dc8206&margin=%5Bobject%20Object%5D&name=image.png&originHeight=37&originWidth=896&originalType=binary&ratio=1&rotation=0&showTitle=false&size=33027&status=done&style=none&taskId=ucbcb6f89-fafe-4769-a066-325d2486762&title=&width=896)

## 二、运行时数据区内部结构

![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648199976256-2e452497-de40-4a5c-bae3-901b784cc77e.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=254&id=ub2da620c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=254&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=278797&status=done&style=none&taskId=u4d25f4f2-6e91-4e94-9a4f-35310ef39a5&title=&width=554)<br
/>![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648199986667-fc13e54c-5906-4cdf-8bc2-a796e7d3f565.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=256&id=u14fe7bf5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=256&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=115391&status=done&style=none&taskId=u641d3a02-0f24-4d95-9f5a-a97ec137dcf&title=&width=554)

### 1. PC寄存器

#### a. 概念

- 对物理PC寄存器的一种抽象模型
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648200049013-01a24822-36ca-4aac-9418-03ee31dab152.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=260&id=u0994e9bd&margin=%5Bobject%20Object%5D&name=image.png&originHeight=260&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=90483&status=done&style=none&taskId=u6450e4d2-76fa-400d-8d04-5547d015980&title=&width=554)

#### b. 作用（面试题）

- 用来存储下一条指令的地址，即将要执行的指令代码，由执行引擎执行
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648200151090-b138376f-8d09-40dd-81ad-7295752685d6.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=296&id=u7e433b93&margin=%5Bobject%20Object%5D&name=image.png&originHeight=296&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=61803&status=done&style=none&taskId=ufca117b0-26e3-4855-b683-f95a9081259&title=&width=554)
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648200188207-2f9ad3d3-3010-4a70-bb86-e6afde25c4e4.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=257&id=u25998e04&margin=%5Bobject%20Object%5D&name=image.png&originHeight=257&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=51937&status=done&style=none&taskId=u245bc549-c6c0-490a-bf58-92cd11e101e&title=&width=554)

### 2. 本地方法（掌握）

#### a. 概念

- 一个Native Method就是一个Java调用非Java代码的接口

#### b. 作用

- 与java环境外交互
- 与操作系统交互
- Sun's java

#### c. 举例

- Thread里面的方法

#### d. 本地方法栈

- 用于管理本地方法的调用
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648200476118-ff6399dc-db85-4ecd-8609-049fbdf2200c.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=277&id=ud7a659ea&margin=%5Bobject%20Object%5D&name=image.png&originHeight=277&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=92248&status=done&style=none&taskId=u2fbdb690-8d9f-4152-a86d-465808e1a18&title=&width=554)
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648200480108-b1882e25-c8f1-4537-8903-0b7b07b6e137.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=229&id=u579d81f4&margin=%5Bobject%20Object%5D&name=image.png&originHeight=229&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=101077&status=done&style=none&taskId=ub01b9e9a-9d03-4499-8dee-85645a4dfba&title=&width=554)

## 三、虚拟机栈（重点）

#### 1. 概念

- 栈是运行时的单位，程序如何运行，如何处理数据
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648201820243-48ba4979-e68c-43f8-8fb6-c2e56fa82c3f.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=277&id=u25b2fdb7&margin=%5Bobject%20Object%5D&name=image.png&originHeight=277&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=44340&status=done&style=none&taskId=u78665fe0-abe2-4bcc-9506-71e47d36f47&title=&width=553)
    - 类比--佛跳墙的菜谱步骤
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648201828429-55c4f7a7-84a1-4242-8a50-6b52f98a2b5c.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=264&id=u21c2b523&margin=%5Bobject%20Object%5D&name=image.png&originHeight=264&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=168839&status=done&style=none&taskId=u38fdf345-d19f-4a9c-a5a9-313fc6e96dc&title=&width=554)

#### 2. 作用

主管java程序的运行，它保存方法的局部变量（8种基本数据类型、对象的引用地址）、部分结果，并参与方法的调用与返回

- 局部变量 VS 成员变量（或属性）
- 基本数据变量 VS 引用类型变量（类、数组、接口）

#### 3. 栈帧

- **a. 存储内容**
    - 局部变量表（局部变量数组或本地变量表）
        - 定义为一个数字数组，主要用于存储方法参数和定义在方法内的局部变量，这些数据类型包括各类基本数据类型、对象引用，以及returnAddress类型。
        - 由于局部变量表是建立在线程的栈上，是线程的私有数据，所以不存在数据的线程安全问题。
        - 局部变量表所需的容量大小是在编译期确认下来的，并保存在方法的Code属性的maximum local variables数据项中，在方法运行期间是不会改变局部变量表的大小的
        - 方法的嵌套调用的次数由栈的大小决定。一般来说，栈越大，方法的嵌套调用次数越多。
        - 局部变量表中的变量只在当前方法调用中有效。在方法执行时，虚拟机通过使用局部变量表完成参数值到参数变量列表的传递过程。 当方法调用结束后，随着方法栈帧的销毁，局部变量表也会随之销毁。
    - 操作数栈
        - 每一个独立的栈帧中除了包含局部变量表以外，还包含一个后进先出的操作数栈，也可以称之为表达式栈。
        - 操作数栈，在方法执行的过程中，根据字节码指令，往栈中写入数据或提取数据，即入栈(push)、出栈(pop)。
            - 某些字节码指令将值压入操作数栈，其余的字节码指令将操作数取出栈，使用他们后再将结果压入栈。
            - 比如： 执行复制、交换、求和等操作
            - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648203350956-29044308-8789-4f92-8e71-02eddea16d9a.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=162&id=ub746894a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=162&originWidth=555&originalType=binary&ratio=1&rotation=0&showTitle=false&size=29379&status=done&style=none&taskId=u2d644af2-8209-458d-a6f9-c39dbc15c70&title=&width=555)
            - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648203360597-be27aa1c-f2d3-42b9-a2d9-f084a20e0cb6.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=216&id=u3c684ab2&margin=%5Bobject%20Object%5D&name=image.png&originHeight=216&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=42188&status=done&style=none&taskId=u7ee53df0-f710-4b50-a297-f851b13be80&title=&width=554)
- **b. 运行原理**
    - 先进后出

#### 4. 五道面试题

-
    1. 举例栈溢出的情况？（StackOverflowError）

    - 通过设置-Xss1m参数调整栈空间大小

-
    2. 调整栈大小，就能保证不出现栈溢出吗？

    - 不能，如果写个递归并且没有出口，那么迟早会出现栈溢出

-
    3. 分配的栈内存越大越好吗？

    - 不是，如果给栈分配过大内存将会导致其他部分没有可用内存

-
    4. 垃圾回收是否会涉及到虚拟机栈？

    - 不会涉及

-
    5. 方法中定义的局部变量是否存在线程安全？

    - 具体问题具体分析

```java
//s1的声明方式是线程安全的
public static void method1(){
    //StringBuffer:线程不安全的
    StringBuffer s1 = new StringBuffer();
    s1.append("A");
    s1.append("B");
    ...
}

解释：
这个例子是线程安全的，s1为局部变量，返回值为void，只能被当前线程操作，是线程安全的。
注意：这里返回值为空（void）
```

```java
注意：把StringBudiler作为参数传进去

//先说结论，这个是线程不安全的
//StringBuilder是线程不安全的
public static void method2(StringBuiler sBuilder){
    sBuilder.append("A");
    sBuilder.append("B");
    ...
}

//我们在main操作一下
public static void main(String[] args){
    StringBuilder s = new StringBuilder();
    
    new Thread(()->{
      s.append("a");
      s.append("b");
    }).start();
    
    method2(s);    
    
}

//它们会抢s的资源，是线程不安全的
//严格的来说sBuilder不是方法内的局部变量，它是形参的局部变量，形参也会存在局部变量表中
```

```java
这次不传参数，而是返回

//结论：不是线程安全的(有可能存在问题)
public static StringBuilder method3(){
    StringBuilder s1 = new StringBuilder();
    s1.append("A");
    s1.append("B");
    ...
    return s1;
}

//引用类型和基本类型不用多说了把
//基本类型包括：byte,short,int,long,char,float,double,Boolean，
//引用类型包括：类类型，接口类型和数组。
//因为StringBuilder是类，一返回出去可能被其他位置上的多个线程所调用
```

```java
返回String，String有点特殊，因为它具有不变性，看源码是String被final声明
    
//结论：线程安全的
public static String method4(){
    StringBuilder s1 = new StringBuilder();
    s1.append("A");
    s1.append("B");
    ...
    return s1.toString();
} 
```

2与3发生了逃逸，作用域不止在方法内部了<br />1与4未发生逃逸，是安全的

---

总结： **创建对象不一定是在堆空间上创建，还可以在栈上创建。**所以这道题方法中定义的局部变量不一定线程安全。

## 四、堆空间（面试）

#### 1. 堆的概述

- 一个JVM实例对应一个进程实例，一个JVM实例有一个运行时数据区(Runtime)
- 一个Runtime就有一个独立的方法区和堆
- 一个进程有多个线程,多个线程共享一个方法区和堆空间
- 每个线程拥有自己独立的程序计数器/本地方法栈/虚拟机栈
- 为了解决多个线程访问出现线程不安全问题-->TLAB(线程私有空间)
- 垃圾回收只会在堆(方法区)当中进行回收

#### 2. 堆内存细分

- **a. 基本划分**
    - 新生代：老年代=1:2
    - 新生代=eden：from：to=8:1:1
    - 创建对象在eden区
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648204341539-35423d46-e245-4745-93e8-1b82586481db.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=283&id=uab4bb8f7&margin=%5Bobject%20Object%5D&name=image.png&originHeight=283&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=143778&status=done&style=none&taskId=u93cc65ce-b2ff-49f6-a43e-3aa67317216&title=&width=554)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648204437431-fdf141af-a815-44c3-b114-9cb40b433c18.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=248&id=u9e401080&margin=%5Bobject%20Object%5D&name=image.png&originHeight=248&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=69023&status=done&style=none&taskId=u94e22c44-c582-4cf8-95ae-a5f7cac7f93&title=&width=554)
- **b. jvisualvm插件安装**
    - 工具-->插件-->可用插件-->Visual GC
        - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648204540212-8d4e640a-0fab-42ef-ab81-8f027ccc568e.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=368&id=u2b1780e1&margin=%5Bobject%20Object%5D&name=image.png&originHeight=368&originWidth=482&originalType=binary&ratio=1&rotation=0&showTitle=false&size=95705&status=done&style=none&taskId=uc1fea230-b315-4da1-b07b-51ed291130a&title=&width=482)
    - idea中安装
        - 安装插件visualvm-launcher
            - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648204514110-4325a5c3-cec5-4fae-88ad-0bc7df9774bc.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=135&id=UFYrD&margin=%5Bobject%20Object%5D&name=image.png&originHeight=135&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=36683&status=done&style=none&taskId=uf473688d-1682-4533-9e6d-a350d78167b&title=&width=554)
        - 配置jdk路径
            - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648204523582-2ade7682-d4b2-4e37-8bae-a7fa8a3299ba.png#clientId=u73edfeae-bbcc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=254&id=u23e05719&margin=%5Bobject%20Object%5D&name=image.png&originHeight=254&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=66492&status=done&style=none&taskId=uc80eb42f-7693-475b-b371-ad1af7da021&title=&width=553)
- **c. OOM内存溢出**
    - **OutOfMemoryError: Java heap space**
- **d. 内存分配策略**
    - 默认对象分配在eden（伊甸园）区
    - 如果一个对象回收次数达到一个阈值就把该对象放到老年代
    - 大对象直接分配到老年代
        - 尽量避免程序中出现过多的大对象
    - 对于体积不大的对象优先分配该对象到eden区的TLAB区
    - 对象还有可能分配在栈空间（逃逸分析）
- **e. TLAB区（重点）**
    - 为什么要有TLAB区？
        - 堆空间是线程共享的，在高并发分配内存的时候，容易出现线程不安全问题
        - 为了解决线程不安全问题，采用加锁机制，会影响性能
    - TLAB区的作用
        - TLAB区是线程私有的一块空间，可以避免线程安全问题
        - 多个线程即使同时分配内存，也可以避免一系列的非线程安全问题，提高内存分配的吞吐量，因此我们将这种分配内存的方式称为快速分配策略
        - JVM将TLAB区作为内存分配的首选区域
            - -XX:-UseTLAB,内存空间很小，仅占eden区的1%(可调)
        - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273688330-d7098e6a-b362-4cef-b13d-ab9f969d1826.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=263&id=ucfb10ae6&margin=%5Bobject%20Object%5D&name=image.png&originHeight=263&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=46932&status=done&style=none&taskId=ub2cb44f9-70d0-486a-b841-ffc91d6ad3e&title=&width=554)
- **f. 图解对象分配过程**
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273799999-b159ccb1-743b-45db-9462-b2038c835d09.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=255&id=u78137800&margin=%5Bobject%20Object%5D&name=image.png&originHeight=255&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=85889&status=done&style=none&taskId=uacc5d4fe-5db7-4550-a5b8-67b21134ec8&title=&width=554)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273805730-0f185590-c157-4658-a4f2-0ee945e00b53.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=118&id=ue2aedd7e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=118&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=28716&status=done&style=none&taskId=uff0eb053-d29d-49ba-b5c6-aac5adc6551&title=&width=554)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273823704-478e72a7-fc53-436a-b507-6ea11f86894c.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=194&id=u7c6afcbe&margin=%5Bobject%20Object%5D&name=image.png&originHeight=194&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=26617&status=done&style=none&taskId=u14ce2a47-f990-455d-96b3-1ea0730e147&title=&width=554)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273829376-cc62f459-af90-457f-acc0-ae0586a4826e.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=170&id=ued91e35e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=170&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=22404&status=done&style=none&taskId=ubb4b1bf6-5fef-45fe-a3c4-9dd97b9665a&title=&width=554)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273837931-e2eead9a-6f92-4199-a7b1-175f00b6e041.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=153&id=uae69a305&margin=%5Bobject%20Object%5D&name=image.png&originHeight=153&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=24919&status=done&style=none&taskId=ud269ccc5-9228-4350-875d-aded5a43057&title=&width=553)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273843085-5ab58cb4-7eed-4adc-a392-24e8890c4341.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=140&id=u0b12e11a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=140&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=36946&status=done&style=none&taskId=u241d1ce5-aabb-4078-b06e-b11f269c59c&title=&width=554)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273846841-0e5e6fa3-df09-464d-b80b-c641f7721628.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=434&id=ub1e39ede&margin=%5Bobject%20Object%5D&name=image.png&originHeight=434&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=111457&status=done&style=none&taskId=uab029575-c369-442c-adaf-d364e190c19&title=&width=554)
- **g. MinorGC/MajorGC/FullGC的对比**
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273923746-279ef055-b211-4b3a-828c-66cc77e0c2cf.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=288&id=u0eb779ac&margin=%5Bobject%20Object%5D&name=image.png&originHeight=288&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=93147&status=done&style=none&taskId=uc47ccfd9-3754-4c3a-b99a-b2ca106ca6e&title=&width=553)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273931617-c271a59c-8c11-46f4-8d68-779d154b40ef.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=189&id=u5a12118f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=189&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=57142&status=done&style=none&taskId=u3ba923bb-16f1-408f-99fc-f922ea34c65&title=&width=554)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273938614-00131380-474c-4a4a-970f-6a8b24bf3d76.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=206&id=u1730d6d4&margin=%5Bobject%20Object%5D&name=image.png&originHeight=206&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=50435&status=done&style=none&taskId=u35c6ad74-5ec1-4325-a1df-4780ce06a03&title=&width=553)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273946295-d02bef64-b7ef-4181-ae11-36aa01c2b3a4.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=262&id=ubc194046&margin=%5Bobject%20Object%5D&name=image.png&originHeight=262&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=65204&status=done&style=none&taskId=uec1c67bb-9897-42a8-9ce9-6b7d8924468&title=&width=554)
- **h. 堆空间分代思想**
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648273990367-1e7bd749-d90e-41ac-9ac5-6676dc6a751e.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=284&id=u67a13e53&margin=%5Bobject%20Object%5D&name=image.png&originHeight=284&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=68633&status=done&style=none&taskId=ua77f11c7-9972-433a-891f-64eb6658792&title=&width=554)

#### 3. 逃逸分析（亮点、重点）

- **1. 为什么存在逃逸分析**
    - 如果对象在堆内存分配--可能引起GC--导致STW--应用程序卡顿
    - 减少对象在堆内存的分配--减少GC--减少STW--减少卡顿，提升性能
- **2. 作用**
    - 在栈上分配
        - 如果一个对象没有发生逃逸，就可以在栈上分配
            - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648284189925-d443d8c6-e5ce-40f1-b0a5-d1b52a3cad4e.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=213&id=u67748503&margin=%5Bobject%20Object%5D&name=image.png&originHeight=213&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=25853&status=done&style=none&taskId=u3c089dc7-3d35-4e78-a9f4-fe33eeade5a&title=&width=554)
        - 随着方法的结束，对象从栈空间被移除（出栈）--不涉及GC--提高程序性能
            - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648284198432-ec343a53-21c7-4907-9e2a-82c15cea410c.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=251&id=u3c89d12f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=251&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56246&status=done&style=none&taskId=u629ad522-7c93-425f-a306-963bd74cac9&title=&width=554)
            - 结论
                - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648284229283-06066cdb-3fa9-47b0-bf6a-9711c58b5963.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=86&id=u58633df0&margin=%5Bobject%20Object%5D&name=image.png&originHeight=86&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=13251&status=done&style=none&taskId=uae3db624-09c8-46d1-a3b6-4adb831390e&title=&width=554)
- **3. 判断对象是否发生逃逸**
    - 当一个对象在方法中被定义之后，对象只在方法内部使用，则认为没有发生逃逸
    - 当一个对象在方法中被定义之后，它被外部方法所引用，则认为发生了逃逸。
        - 例如：作为调用参数传递到其他对方。
- **4. 逃逸分析优化算法**
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648284376241-165ff8aa-3a4a-4367-a470-701b9b2c2501.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=248&id=u864e9637&margin=%5Bobject%20Object%5D&name=image.png&originHeight=248&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=70610&status=done&style=none&taskId=u83704d0d-0c0d-4052-8d11-d07305d26ac&title=&width=554)
    - 栈上分配
        - 新建对象尽量写成局部变量
        - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648284435596-ef45ede3-3b3f-4803-854a-2fb2dc171a72.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=172&id=u0747b786&margin=%5Bobject%20Object%5D&name=image.png&originHeight=172&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=47935&status=done&style=none&taskId=ufb23bd3c-5595-4a53-8aad-21319f8eb09&title=&width=554)
    - 同步省略
        - 同步代码块锁对象只能被一个线程访问，就可以取消同步代码块
        - 取消同步代码块这个过程--锁消除
        - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648284443759-63ce68de-81c9-4863-8716-6b109adeb744.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=211&id=u163901bc&margin=%5Bobject%20Object%5D&name=image.png&originHeight=211&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=65641&status=done&style=none&taskId=u2e9f1291-bb4c-40a0-ace3-98e727af346&title=&width=554)
        - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648284456739-5ce411cd-afaf-4709-a6c0-28ebeb18cb5e.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=277&id=u17851fd4&margin=%5Bobject%20Object%5D&name=image.png&originHeight=277&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=54540&status=done&style=none&taskId=ue29bdb08-cd6b-4f26-ab60-2ab427c3145&title=&width=554)
    - 标量替换
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648284941118-6d3af4bf-fc30-4e53-9722-d13ca02e32a3.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=233&id=u81af537a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=233&originWidth=801&originalType=binary&ratio=1&rotation=0&showTitle=false&size=88566&status=done&style=none&taskId=u98b3f5f3-49e8-4146-ade7-60a127a7567&title=&width=801)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648284952588-59bcb1b4-83ef-4a31-9ca8-ff06ed905f09.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=213&id=u755e05a9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=213&originWidth=761&originalType=binary&ratio=1&rotation=0&showTitle=false&size=70721&status=done&style=none&taskId=ud3de0288-2f4a-466c-a38f-e1740cb12d5&title=&width=761)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648284996778-1d3fd2d0-92c7-436d-a4c5-f8f80bea9fba.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=466&id=ue48bf955&margin=%5Bobject%20Object%5D&name=image.png&originHeight=466&originWidth=931&originalType=binary&ratio=1&rotation=0&showTitle=false&size=221326&status=done&style=none&taskId=u5800007c-64ae-4de4-88ab-19e1ac1d473&title=&width=931)
        - 标量
            - 指一个无法被分解的更小的数据结构--java原始数据类型
        - 聚合量
            - 可以进行拆解的--类对象
        - 效果
            - 由于原来需要创建对象，现在不需要了
                - 减少了堆内存分配
                - 减少了内存使用
                - 减少了GC
- **5. 逃逸分析缺点**
    - 由于判定对象是否发生逃逸也需要消耗性能，所以逃逸分析至今还是有一定的缺点，并且技术还没有完全成熟
    - 无法保证逃逸分析的性能消耗一定高于他的消耗。虽然经过逃逸分析可以做到标量替换、栈上分配以及锁消除，但是逃逸分析自身也是需要一系列的复杂分析的，这其实也是一个相对耗时的过程

### 五、方法区（元空间）（掌握）

![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648343255357-2c716141-c67c-4642-9e47-82a1fe749d16.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=229&id=u9ee2d597&margin=%5Bobject%20Object%5D&name=image.png&originHeight=286&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=true&size=41873&status=done&style=none&taskId=u77bba36f-ff5b-4e2f-8bda-4a1878d1bbc&title=%E5%A0%86%E3%80%81%E6%96%B9%E6%B3%95%E5%8C%BA%E3%80%81%E6%A0%88%E4%B9%8B%E9%97%B4%E7%9A%84%E5%85%B3%E7%B3%BB&width=443.2 "堆、方法区、栈之间的关系")

#### 1. 概念

- 是各个线程共享的一个区域，方法区的大小直接决定系统可以加载多少个类class

#### 2. 如何设置方法区（元空间）的大小

- -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
- 如果方法区不足，就会报错 OutOfMemoryError： Compressed class space

#### 3. 内部结构

- **类型信息**
    - 类（class）、接口（interface）、枚举（enum）、注解（annotation）等
        - 1、这个类型的完整有效名称（全名=包名+类名）
        - 2、这个类型直接父类的完整有效名（对于interface或是java.lang.Object，都没有父类）
        - 3、这个类型的修饰符（public、abstract、final的某个子集）
        - 4、这个类型直接接口的一个有序列表
- **域信息**
    - JVM必须在方法区保存类型的所有域的相关信息以及域的声明顺序
    - 域的相关信息包括：域名称、域类型、域修饰符（public、private、protected、static、final、volatile、transient的某个子集）
- **方法信息**
    - 方法名称
    - 方法的返回值类型（或void）
    - 方法的参数的数量和类型（按顺序）
    - 方法的修饰符public、private、protected、static、final、volatile、transient的某个子集）
    - 方法的字节码（bytecodes）、操作数栈、局部变量表及大小（abstract和native方法除外）
    - 异常表（abstract和native方法除外）
        - 每个异常处理的开始位置、结束位置、代码处理在程序计数器中的偏移地址、被捕获的异常的类的常量池索引
- 常量
- 静态变量、类变量
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648343381159-09f687fb-9633-4ad3-9d14-eb2e20164cc9.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=253&id=u8b36f8fe&margin=%5Bobject%20Object%5D&name=image.png&originHeight=316&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=116261&status=done&style=none&taskId=u976483ab-5f3a-4791-a6c9-7231954795c&title=&width=443.2)
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648343398578-82484533-4af1-48db-b8f7-a42b08cc8647.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=168&id=ucdf1be1a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=210&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=43389&status=done&style=none&taskId=u8efea1c3-9329-4375-a1e0-9748ee530c6&title=&width=443.2)

#### 4. 方法区垃圾回收

- 必要又难以让人满意
- 主要回收常量池里面废弃的常量和不常使用的类型
- 常量池常量没有被任何地方引用就可以回收

#### 5. 运行时常量池

- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648344084664-2a63c3cc-30f3-431d-b272-e6a396bd5ad6.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=234&id=u79106117&margin=%5Bobject%20Object%5D&name=image.png&originHeight=293&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=219430&status=done&style=none&taskId=u14bbf4d4-595a-46ee-9516-16aa443c7f4&title=&width=443.2)
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648344173518-76ab2492-b06b-49d0-a2ae-a622259af37f.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=81&id=u3f33587c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=101&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=18840&status=done&style=none&taskId=ub87290f2-430b-490e-9578-93bb98f9fe8&title=&width=443.2)
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648344180811-06eaeb38-2c0c-44a0-9125-afafbdd0b5f3.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=253&id=u2c1c9d55&margin=%5Bobject%20Object%5D&name=image.png&originHeight=316&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=105803&status=done&style=none&taskId=u16ae7764-1936-4f64-b2e6-7ec819e2c87&title=&width=443.2)

### 六、垃圾回收（理解）

#### 1. 为什么要垃圾回收

- 如果不进行垃圾回收，内存迟早要消耗完
- 释放没用的对象，将碎片整理所占用的堆内存移到堆的一端，方便JVM整理内存分配给新的对象
- 随着应用程序所应付的业务越来越庞大、复杂、用户越来越多，没有GC，就不能保证应用程序的正常执行

#### 2. 什么是垃圾

- 在运行程序中没有任何指针指向该对象

#### 3. 早期垃圾回收方式

- C/C++时代垃圾回收都是通过手工回收，开发人员可以通过new关键字对内存进行申请，并且使用delete关键字进行内存释放

#### 4. 自动内存管理

- 开发人员无需手动参与内存申请与释放，就可以降低内存泄露与内存溢出的风险
    - 优点：让开发人员专注于业务开发
    - 缺点：弱化开发人员解决内存溢出或泄露的能力

#### 5. 应该关心那些区域进行回收

- 只有方法区+堆
- 频繁收集young区
- 较少收集old区
- 基本不动perm区/元空间

### 七、垃圾回收算法

#### 1. 标记

- 垃圾回收之前，判断对象是存活

#### 2. 引用计数算法

![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648345857666-86a71910-01de-4067-b07b-6f433ebee56c.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=217&id=ufe9b206c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=271&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=91471&status=done&style=none&taskId=u2c8dbdcb-f775-4d20-82ea-c418103154e&title=&width=443.2)

- **概念**
    - 当对象被引用的时候计数器加1
- **优点**
    - 实现简单，垃圾回收对象便于辨识，判定效率高，回收没有延迟性
- **缺点**
    - 致命问题：无法处理循环引用的情况

#### 3. 可达性分析算法

![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648346451416-6bc796b8-c5e0-47b9-8533-fb61b041ab07.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=133&id=u304b54bb&margin=%5Bobject%20Object%5D&name=image.png&originHeight=166&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=54624&status=done&style=none&taskId=u524fb090-73dc-4d5a-aaab-6212190ca29&title=&width=443.2)<br
/>![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648346455879-d684f604-1236-465b-9b37-f98a8c0ef4d5.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=198&id=uad4cc647&margin=%5Bobject%20Object%5D&name=image.png&originHeight=247&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=79836&status=done&style=none&taskId=ub06253f8-81d8-4cd5-8fb4-ec00dcc06ef&title=&width=443.2)

- **概念**
    - 从根节点为起始点从上往下搜索根对象所连接对象是否可达
    - 搜索走过的路径被称为引用链
    - 不可达对象称为垃圾
- GC roots包括以下元素（了解）
    - 方法区中常量引用对象
    - 同步sync关键字持有对象
    - 静态类变量
- 小技巧
    - 由于root采用栈方式存放变量和指针，所以如果一个指针，他保存了堆内存里面的对象，但是自己又不存放在堆内存里面，那它就一定是root

#### 4. 标记清除算法

- 缺点
    - 效率不算高
    - 在进行GC的时候，需要停止整个应用程序，导致用户体验差
    - 这种方式清理出来的空闲内存是不连续的，产生内存碎片，还需要维护一个空闲列表

#### 5. 标记压缩算法（老年代）

- 把存活对象的索引进行移动

#### 6. MinorGC/MajorGC/FullGC的对比

- MinorGC
    - 只回收新生代
    - 新生代空间不足的时候，该区域有个特点 对象大部分是朝生夕死
    - 会触发STW 暂停其他用户线程 垃圾收集结束 用户线程才恢复
- MajorGC
    - 回收老年代
    - 回收速度比MinorGC慢10倍以上 STW时间更长
- FullGC
    - 回收整个堆与方法区
    - 更应该尽量避免

#### 7. 复制算法(新生代)

![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347409494-e1ef764d-d22f-48ff-9a96-14ed167af790.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=136&id=u287a128f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=170&originWidth=557&originalType=binary&ratio=1&rotation=0&showTitle=false&size=15967&status=done&style=none&taskId=uad67e77b-de26-4047-914a-1b32c4bac67&title=&width=445.6)<br
/>![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347417363-66b5f1b4-a151-42d2-bc8f-e0a7d281b024.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=126&id=u9c33e2e9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=158&originWidth=558&originalType=binary&ratio=1&rotation=0&showTitle=false&size=23635&status=done&style=none&taskId=ue4de7837-f86c-45c8-866d-bf577fa3e77&title=&width=446.4)<br
/>![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347442958-3d0237ea-d75f-4d90-afde-506c556ef073.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=217&id=u6f3bd9e0&margin=%5Bobject%20Object%5D&name=image.png&originHeight=271&originWidth=557&originalType=binary&ratio=1&rotation=0&showTitle=false&size=23761&status=done&style=none&taskId=u844b6eec-9984-4bc9-beb8-25ec633a0a8&title=&width=445.6)<br
/>![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347448255-389eeb8f-e9aa-47a7-b1be-e223683eebcd.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=204&id=u3d47000a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=255&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=64334&status=done&style=none&taskId=ue6ba7523-7804-4332-b79f-881ee821476&title=&width=443.2)

- **步骤**
    - 第一次回收是对eden区进行回收
    - 第二次回收是对eden+from作为回收主战场
    - 回收过程中 存活对象还要加1
    - 把from和to进行交换 from变为to to变为from(交换)
- **优缺点**
    - 优点:不会出现空间垃圾碎片
    - 缺点:需要两倍活着对象的空间大小

#### 8. 分代垃圾回收算法(重重点)

![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347524101-1ace68ac-e922-4fd5-9d52-ecda0973fc31.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=211&id=u9b5f08b3&margin=%5Bobject%20Object%5D&name=image.png&originHeight=264&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=76292&status=done&style=none&taskId=ub6527c0c-eeff-4124-816d-1dadd262d25&title=&width=443.2)

- 新生代和老年代回收算法
- 新生代回收算法和老年代进行交换
    - 老年代里面的对象经过GC以后大部分都存活 采用复制算法
    - 会产生较大的性能问题

#### 9. 增量收集算法

![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347538859-4c982546-dc60-4174-8830-601a84173985.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=223&id=udd1dcad7&margin=%5Bobject%20Object%5D&name=image.png&originHeight=279&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=135194&status=done&style=none&taskId=ua8c937f0-8909-4bf2-baf9-81875d34ca6&title=&width=443.2)<br
/>![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347545812-3270995d-18b5-4cac-9588-02fecc066409.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=90&id=ue16bcdef&margin=%5Bobject%20Object%5D&name=image.png&originHeight=113&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=32843&status=done&style=none&taskId=u7af730f5-b9af-4035-bb05-b357cc53c92&title=&width=443.2)

- **概念**
    - 垃圾收集线程每次只收集一小部分内存空间，接着切换到应用线程
    - 依次反复执行完成垃圾收集 可以避免长时间STW
- **缺点**
    - 由于线程进行切换 存在上下文切换开销 造成吞吐量下降

#### 10. 分区回收算法

![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347575457-f77f9711-ff13-4b5b-a7e6-ec5eed97551d.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=156&id=u6fc73c24&margin=%5Bobject%20Object%5D&name=image.png&originHeight=195&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=50669&status=done&style=none&taskId=uce733d93-db77-488c-a2c3-fd7f458c819&title=&width=443.2)<br
/>![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347580518-e445ac73-674d-4ab5-abf2-0e3c198651a3.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=267&id=u01550265&margin=%5Bobject%20Object%5D&name=image.png&originHeight=334&originWidth=519&originalType=binary&ratio=1&rotation=0&showTitle=false&size=224785&status=done&style=none&taskId=ub08a75f6-f4ea-4002-a1c1-02ae17c5933&title=&width=415.2)<br
/>![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347587685-cc141577-286d-4db8-9d03-ad3d3875ec58.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=142&id=uaef3fdd4&margin=%5Bobject%20Object%5D&name=image.png&originHeight=178&originWidth=554&originalType=binary&ratio=1&rotation=0&showTitle=false&size=49499&status=done&style=none&taskId=ua741086b-2281-4e2c-bd74-0bf5a5d8743&title=&width=443.2)

- 把一个内存区域划分为多个内存空间，每次只回收若干个小区域内存

#### 11. 总结

- 实际回收要复杂的多，根据具体场景进行选用，目前用的最多的是复合算法

### 八、垃圾回收日志（会看）

- 分析GC日志
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347647257-7ee058b1-1732-4c39-a810-f03b47dda9c5.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=166&id=u5638e215&margin=%5Bobject%20Object%5D&name=image.png&originHeight=208&originWidth=631&originalType=binary&ratio=1&rotation=0&showTitle=false&size=148872&status=done&style=none&taskId=u0b3c17d8-c9af-4d49-ab50-3dfeb48d36e&title=&width=504.8)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347652795-13fea456-1576-4154-af37-a74f57d5a932.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=290&id=u340d0d63&margin=%5Bobject%20Object%5D&name=image.png&originHeight=362&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=65508&status=done&style=none&taskId=uc97e0ca1-f5f7-4eaa-89e9-22a3955226f&title=&width=442.4)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347658899-f1b6a4c4-5cae-4ff9-87b5-c654737396cc.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=170&id=u19af7514&margin=%5Bobject%20Object%5D&name=image.png&originHeight=213&originWidth=653&originalType=binary&ratio=1&rotation=0&showTitle=false&size=108389&status=done&style=none&taskId=ub193ac54-2e63-4780-8e05-c7c6b687a92&title=&width=522.4)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/26075477/1648347663581-e3e82df0-2e52-474e-8094-3bcfbbd80652.png#clientId=u0e857957-100f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=322&id=ue596d497&margin=%5Bobject%20Object%5D&name=image.png&originHeight=402&originWidth=553&originalType=binary&ratio=1&rotation=0&showTitle=false&size=67658&status=done&style=none&taskId=u76cb07b7-12e2-4234-8cd0-1d7894894ed&title=&width=442.4)
- 借助工具
    - [https://gceasy.io/](https://gceasy.io/)

