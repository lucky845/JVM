package com.atguigu.part05;

import java.awt.*;

/**
 * @author lucky845
 * @date 2022年03月27日 13:54
 */
public class Test03_ScalarReplace {

    /*
        标量替换测试
            第一次 未使用标量替换: -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations  49 ms
                发生了GC
            第二次 用标量替换: -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations 6 ms
                未发生GC
     */

    // 没有发生逃逸
    public static void alloc() {
        Point point = new Point();
//        int x=5;
//        int y=6;
        point.setLocation(5, 6);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为： " + (end - start) + " ms");
    }

}
