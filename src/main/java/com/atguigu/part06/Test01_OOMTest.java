package com.atguigu.part06;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author lucky845
 * @date 2022年03月27日 14:02
 */
public class Test01_OOMTest extends ClassLoader {

    /*
      jdk6/7中：-XX:PermSize=10m 设置永久代初始分配空间 -XX:MaxPermSize=10m 设置永久代最大分配空间
        -XX:PermSize=10m -XX:MaxPermSize=10m

      jdk8中：-XX:MetaspaceSize=10m 设置元空间初始分配空间 -XX:MaxMetaspaceSize=10m 设置元空间最大分配空间
         -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
     */
    public static void main(String[] args) {
        int j = 0;
        try {
            Test01_OOMTest test = new Test01_OOMTest();
            for (int i = 0; i < 10000; i++) {
                // 创建ClassWriter对象，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                // 指明版本号，修饰符，类名，包名，父类，接口
                classWriter.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                // 返回byte[]
                byte[] code = classWriter.toByteArray();
                // 类的加载
                test.defineClass("Class" + i, code, 0, code.length);//Class对象
                j++;
            }
        } finally {
            System.out.println(j);
        }

    }

}
