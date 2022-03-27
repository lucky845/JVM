package com.atguigu.part07;

import com.atguigu.util.SleepUtils;

import java.util.ArrayList;

/**
 * @author lucky845
 * @date 2022年03月27日 14:13
 */
public class Test02_GCLog {

    /*
        -Xms60m -Xmx60m -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -Xloggc:D:\gc.log
     */
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            // 100KB
            byte[] arr = new byte[1024 * 100];
            list.add(arr);
            SleepUtils.sleep(5);
        }
    }

}
