package com.atguigu.part05;

/**
 * @author lucky845
 * @date 2022年03月27日 13:47
 */
public class Test01_EscapeAnalysis {

    public Test01_EscapeAnalysis obj;

    // 方法返回EscapeAnalysis对象，发生逃逸
    public Test01_EscapeAnalysis getInstance() {
        return obj == null ? new Test01_EscapeAnalysis() : obj;
    }

    // 发生逃逸 obj是一个成员变量
    public void setObj() {
        this.obj = new Test01_EscapeAnalysis();
    }

    // 对象的作用域仅在当前方法中有效，没有发生逃逸
    public void useEscapeAnalysis() {
        Test01_EscapeAnalysis e = new Test01_EscapeAnalysis();
    }

}
