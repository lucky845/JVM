package com.atguigu.part02;

/**
 * @author lucky845
 * @date 2022年03月25日 16:25
 */
public class Test02_StackFrame {
    public static void main(String[] args) {
        Test02_StackFrame test = new Test02_StackFrame();
        test.method1();
        System.out.println("main()正常结束");
    }

    public void method1() {
        int a = 0;
        System.out.println("method1()开始执行...");
        method2(50);
        System.out.println("method1()执行结束...");
    }

    public void method2(int w) {
        int a = 10;
        System.out.println("method2()开始执行...");
        method3();
        System.out.println("method2()即将结束...");
    }

    public void method3() {
        int a = 20;
        System.out.println("method3()开始执行...");
        System.out.println("method3()即将结束...");
    }

}
