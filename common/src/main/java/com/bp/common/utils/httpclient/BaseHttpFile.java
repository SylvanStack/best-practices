package com.bp.common.utils.httpclient;

import lombok.Data;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @description: HttpFile
 * @author: hansiyuan
 * @date: 2022/3/10 4:09 PM
 */
@Data
public class BaseHttpFile implements Serializable {
    private static final long serialVersionUID = 8235051777898094519L;
    /**
     * 入参名称
     */
    private String paramName;

    /**
     * 文件流
     */
    private InputStream inputStream;

    /**
     * 文件名，带后缀
     */
    private String fileName;
}
