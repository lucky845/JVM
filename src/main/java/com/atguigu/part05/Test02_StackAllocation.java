package com.atguigu.part05;

import com.atguigu.util.SleepUtils;

import java.awt.*;

/**
 * @author lucky845
 * @date 2022年03月27日 13:50
 */
public class Test02_StackAllocation {

    /*
        栈上分配
            第一次 未使用逃逸分析: -Xmx256m -Xms256m -XX:-DoEscapeAnalysis -XX:+PrintGCDetails  64 ms 而且有GC
            第二次 用逃逸分析: -Xmx256m -Xms256m -XX:+DoEscapeAnalysis -XX:+PrintGCDetails  4 ms 默认使用了逃逸分析
            结论:第一次发生了GC 并且花费更多的时间
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        // 查看执行时间
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为： " + (end - start) + " ms");
        // 为了方便查看堆内存中对象个数，线程sleep
        SleepUtils.sleep(1000000);
    }

    // 未发生逃逸
    private static void alloc() {
        Point point = new Point();
    }

}
