package java.lang;

/**
 * @author lucky845
 * @date 2022年03月25日 19:47
 */
public class TestPackageName {

    public static void main(String[] args) {
        // JDK安全异常 java.lang.SecurityException: Prohibited package name: java.lang
        // 定义包名、类名或者变量名的时候尽量避免和JDK一致（如rt：JDK中的rt.jar）
        System.out.println("lucky845");
    }

}
