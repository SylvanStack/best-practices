package com.yuanstack.bp.core.business.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * 使用流(Source)与汇(Sink)来对文件进行常用操作
 *
 * @author hansiyuan
 * @date 2022年03月28日 23:29
 */
public class IoExample {
    public static void main(String[] args) throws IOException {
        String sourcePath = "";
        String targetPath = "";
        // 创建对应的Source和Sink
        CharSource charSource = Files.asCharSource(new File(sourcePath), Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(new File(targetPath), Charsets.UTF_8);
        charSource.copyTo(charSink);
    }
}
