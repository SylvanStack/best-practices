package com.bp.core.advance.jdk8.lambda;

/**
 * @description: 匿名类的问题：啰嗦不易读、
 * @author: hansiyuan
 * @date: 2021/11/5 3:41 下午
 */
public class AnonymousClassIssue {
    public final int value = 4;

    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String... args) {
        AnonymousClassIssue m = new AnonymousClassIssue();
        m.doIt(); // ???
    }
}
