package com.yuanstack.bp.core.design.create.singleton.logger;

/**
 * @description: 日志使用场景1
 * @author: hansiyuan
 * @date: 2022/4/1 5:23 PM
 */
public class UserController {
    private OriginLogger logger = new OriginLogger();
    public void login(String username, String password){
        // ...省略业务逻辑代码...
        logger.log(username + " logined!");
    }
}
