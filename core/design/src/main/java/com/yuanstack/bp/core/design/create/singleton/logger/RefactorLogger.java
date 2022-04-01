package com.yuanstack.bp.core.design.create.singleton.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description: 单例日志
 * Java 语言来说，单例类对象的唯一性的作用范围并非进程，而是类加载器（Class Loader）
 * @author: hansiyuan
 * @date: 2022/4/1 5:35 PM
 */
public class RefactorLogger {
    private FileWriter writer;
    private static final RefactorLogger instance = new RefactorLogger();

    private RefactorLogger() {
        File file = new File("/Users/hansiyuan/MyCode/my-project/best-practices/docs/log.txt");
        try {
            //true表示追加写入
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RefactorLogger getInstance() {
        return instance;
    }

    public void log(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
