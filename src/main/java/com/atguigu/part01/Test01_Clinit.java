package com.atguigu.part01;

/**
 * @author lucky845
 * @date 2022年03月25日 16:11
 * 安装jclasslib插件
 */
public class Test01_Clinit {

    // 任何一个类声明之后，内部至少存在一个类的构造器
    private int a = 1;
    // 有静态变量赋值和静态代码块 才会有<clinit>
    private static int b = 3;

    static {
        int c = 4;
    }

    public Test01_Clinit() {
        a = 10;
        a = 20;
    }

}
