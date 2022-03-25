package com.atguigu.part03;

/**
 * @author lucky845
 * @date 2022年03月25日 16:30
 */
public class Test01_StackOver {
    // 栈调用深度  StackOverflowError
    // 默认 22640(默认不足1M) -Xss1m 22634  -Xss5m 298929
    private static int count;

    public static void recursion() {
        count++;
        recursion();
    }

    public static void main(String[] args) {
        try {
            recursion();
        } catch (Throwable t) {
            System.out.println("调用最大深入：" + count);
            t.printStackTrace();
        }
    }
}
