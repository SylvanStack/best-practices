package com.yuanstack.bp.core.design.singleton;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一个类只允许创建一个对象（或者实例），那这个类就是一个单例类
 *
 * @author hansiyuan
 * @date 2022年03月14日 23:03
 */
public class SingletonLogger {
    private FileWriter writer;
    private static final SingletonLogger LOGGER = new SingletonLogger();

    private SingletonLogger()  {
        File file = new File("D:\\MyCode\\MyGithub\\best-practices\\docs\\log.txt");
        //true表示追加写入
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SingletonLogger getInstance() {
        return LOGGER;
    }

    public void log(String message) throws IOException {
        writer.write(message);
    }
}
