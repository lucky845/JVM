package com.atguigu.part04;

/**
 * @author lucky845
 * @date 2022年03月27日 10:27
 */
public class Test04_AllocateObject {

    /*
        -Xmx64M 最大堆内存
        -Xms64M 最小堆内存
        -XX:+PrintGCDetails 打印GC日志信息
        -XX:+UseSerialGC 使用Serial垃圾收集器
        -XX:MaxTenuringThreshold=15 对象晋升老年代的年龄阈值
        -XX:PretenureSizeThreshold=1024000 超过这个值的时候，对象直接在old区分配内存
        -XX:-UseTLAB 是否开启TLAB
     */
    public static void main(String[] args) {
        // 例子一 参数：-Xmx64M -Xms64M -XX:+PrintGCDetails
        // 测试  创建对象优先在eden区
//        for (int i = 0; i < 5; i++) {
//            byte[] b = new byte[1024 * 1024];
//        }

        // 参数：-Xmx1024M -Xms1024M -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintGCDetails
        // 当被GC回收15次才会晋升到老年代
//        for (int k = 0; k < 20; k++) {
//            for (int j = 0; j < 300; j++) {
//                byte[] b = new byte[1024 * 1024];
//            }
//        }


        // 大对象分配在老年代
        // 参数：-Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1024000
//        Map<Integer, byte[]> map = new HashMap<>();
//        for (int i = 0; i < 5; i++) {
//            byte[] b = new byte[1024 * 1024];
//            map.put(i, b);
//        }

        // 默认使用了TLAB区
        // 参数：-Xmx30M -Xms30M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000  -XX:-UseTLAB
//        Map<Integer, byte[]> map = new HashMap<Integer, byte[]>();
//        for (int i = 0; i < 5 * 1024; i++) {
//            byte[] b = new byte[1024];
//            map.put(i, b);
//        }
    }

}
