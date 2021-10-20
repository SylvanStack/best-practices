package com.example.demo.business.io;

import java.io.*;

/**
 * @description: 文件操作工具类
 * @author: hansiyuan
 * @date: 2021/10/18 7:49 下午
 */
public class FileUtil {
    public static void main(String[] args) {


    }

    /**
     * 复制文件
     *
     * @param srcFile 源文件
     * @param dstFile 目标文件
     */
    public static void copyFile(File srcFile, File dstFile) {
        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(dstFile)) {
            int len;
            byte[] buffer = new byte[4096];
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            // ... handle IO exception
        }
    }

    /**
     * 输出到文件
     */
    public static void printToFile(File dest, String content) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dest, true))) {
            writer.print(content);
        } catch (IOException e) {
            // ... handle IO exception
        }
    }


}
