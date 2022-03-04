package com.bp.scaffolding.service;

import com.bp.scaffolding.common.expection.BaseException;
import com.bp.scaffolding.common.expection.BaseExceptionType;
import org.springframework.stereotype.Service;

/**
 * @description: 模仿异常服务
 * @author: hansiyuan
 * @date: 2022/3/4 3:02 PM
 */
@Service
public class ExceptionService {
    /**
     * 服务层，模拟系统异常
     */
    public void systemBizError() {
        try {
            Class.forName("com.mysql.jdbc.xxxx.Driver");
        } catch (ClassNotFoundException e) {
            throw new BaseException(
                    BaseExceptionType.SYSTEM_ERROR,
                    "在XXX业务，myBiz()方法内，出现ClassNotFoundException，请将该信息告知管理员");
        }
    }

    /**
     * 服务层，模拟用户输入数据导致的校验异常
     */
    public void userBizError(int input) {
        //模拟业务校验失败逻辑
        if (input < 0) {
            throw new BaseException(
                    BaseExceptionType.USER_INPUT_ERROR,
                    "您输入的数据不符合业务逻辑，请确认后重新输入！");
        }

        //…… 其他的业务
    }
}
