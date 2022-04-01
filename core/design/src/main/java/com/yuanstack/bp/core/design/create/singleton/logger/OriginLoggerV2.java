package com.yuanstack.bp.core.design.create.singleton.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @description: 解决OriginLogger并发问题
 * @author: hansiyuan
 * @date: 2022/4/1 5:30 PM
 */
public class OriginLoggerV2 {
    private Writer writer;

    public OriginLoggerV2()  {
        File file = new File("/Users/hansiyuan/MyCode/my-project/best-practices/docs/log.txt");
        //true表示追加写入
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message){
        try {
            synchronized(OriginLoggerV2.class){
                writer.write(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
