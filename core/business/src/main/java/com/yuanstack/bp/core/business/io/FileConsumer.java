package com.yuanstack.bp.core.business.io;

/**
 * 文件处理函数式接口
 * @author hansiyuan
 * @date 2022年03月28日 23:16
 */
@FunctionalInterface
public interface FileConsumer {

    /**
     * 函数式接口抽象方法
     * @param fileContent - 文件内容字符串
     */
    void fileHandler(String fileContent);

}
