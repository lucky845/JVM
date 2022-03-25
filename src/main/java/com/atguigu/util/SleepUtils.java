package com.atguigu.util;

/**
 * @author lucky845
 * @date 2022年03月25日 20:49
 */
public class SleepUtils {
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
