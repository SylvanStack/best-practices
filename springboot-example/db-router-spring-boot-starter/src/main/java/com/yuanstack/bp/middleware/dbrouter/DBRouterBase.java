package com.yuanstack.bp.middleware.dbrouter;

/**
 * @description: 数据源基础配置
 * @author: hansiyuan
 * @date: 2022/4/2 11:59 AM
 */
public class DBRouterBase {

    private String tbIdx;

    public String getTbIdx() {
        return DBContextHolder.getTBKey();
    }

}

