package com.yuanstack.bp.middleware.dbrouter;

import com.yuanstack.bp.middleware.dbrouter.annotation.DBRouter;

/**
 * @description: 用户Dao
 * @author: hansiyuan
 * @date: 2022/4/2 2:12 PM
 */
public interface IUserDao {

    @DBRouter(key = "userId")
    void insertUser(String req);

}

