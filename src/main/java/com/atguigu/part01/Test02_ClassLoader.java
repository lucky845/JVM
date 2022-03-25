package com.atguigu.part01;

/**
 * @author lucky845
 * @date 2022年03月25日 16:18
 */
public class Test02_ClassLoader {

    public static void main(String[] args) {

        // 应用类加载器 sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);

        // 扩展类加载器 sun.misc.Launcher$ExtClassLoader@1b6d3586
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("extClassLoader = " + extClassLoader);

        // 启动类加载器 null
        ClassLoader bootStrapClassLoader = extClassLoader.getParent();
        System.out.println("bootStrapClassLoader = " + bootStrapClassLoader);

        // 如果是我们自己写的类  默认是AppClassLoader去加载
        ClassLoader classLoader = Test02_ClassLoader.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);

        // 启动类加载器--java中所有核心库里面的类都是由启动类加载器去加载
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println("classLoader1 = " + classLoader1);


    }

}
