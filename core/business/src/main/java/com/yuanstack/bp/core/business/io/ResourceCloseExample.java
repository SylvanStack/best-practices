package com.yuanstack.bp.core.business.io;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hansiyuan
 * @date 2022年03月29日 0:03
 */
public class ResourceCloseExample {
    public void newFileHandle(String url,FileConsumer fileConsumer) {
        try (
                // 声明、创建文件的读取流
                FileInputStream fileInputStream =
                        new FileInputStream(url);

                InputStreamReader inputStreamReader =
                        new InputStreamReader(fileInputStream);

                BufferedReader bufferedReader =
                        new BufferedReader(inputStreamReader);
        ) {

            // 定义行变量和内容sb
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            // 循环读取文件内容
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            // 调用函数式接口方法，将文件内容传递给lambda表达式，实现业务逻辑
            fileConsumer.fileHandler(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oldFileHandle(String url,
                              FileConsumer fileConsumer) {
        // 声明
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        // 创建文件读取流
        try {
            fileInputStream = new FileInputStream(url);

            inputStreamReader =
                    new InputStreamReader(fileInputStream);

            bufferedReader =
                    new BufferedReader(inputStreamReader);

            // 定义行变量和内容sb
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            // 循环读取文件内容
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            // 调用函数式接口方法，将文件内容传递给lambda表达式，实现业务逻辑
            fileConsumer.fileHandler(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 关闭流资源
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
