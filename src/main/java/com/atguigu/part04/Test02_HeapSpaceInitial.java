package com.atguigu.part04;

import com.atguigu.util.SleepUtils;

/**
 * @author lucky845
 * @date 2022年03月25日 20:59
 */
public class Test02_HeapSpaceInitial {

    /*
      1.默认堆空间
           初始堆空间大小:物理内存/64
           最大堆空间大小:物理内存/4
      2.设置堆空间大小
           初始堆空间大小(-Xms)
           新生代+老年代
           最大堆空间大小(-Xmx)
           新生代+老年代
      3.手动设置堆空间
           -Xms600m -Xmx600m
      4.虽然新生代默认占比eden:from:to=8:1:1 但是要生效必须加上一个 -XX:SurvivorRatio=8
     */
    public static void main(String[] args) {
        // 返回的是java虚拟机中堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        // 返回的是java虚拟机中最大堆内存
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        // 这里的结果是580Mb--->eden+from/to+old里面的内容
        System.out.println("-Xms" + initialMemory + "Mb");
        System.out.println("-Xmx" + maxMemory + "Mb");

        SleepUtils.sleep(100000000);
    }

}
