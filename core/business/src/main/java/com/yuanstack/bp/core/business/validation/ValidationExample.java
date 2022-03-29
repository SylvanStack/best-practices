package com.yuanstack.bp.core.business.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;

/**
 * @author hansiyuan
 * @date 2022年03月28日 23:54
 */
public class ValidationExample {
    // 验证器对象
    private Validator validator;
    // 待验证对象
    private UserInfo userInfo;
    // 验证结果集合
    private Set<ConstraintViolation<UserInfo>> set;
    // 验证结果集合
    private Set<ConstraintViolation<UserInfoService>> otherSet;

    /**
     * 初始化操作
     */
    public void init() {
        // 初始化验证器
        validator = Validation.buildDefaultValidatorFactory()
                .getValidator();

        // 初始化待验证对象 - 用户信息
        userInfo = new UserInfo();
//        userInfo.setUserId("zhangxiaoxi");
        userInfo.setUserName("张小喜");
        userInfo.setPassWord("zhangxiaoxi");
//        userInfo.setEmail("zhangxiaoxi@sina.cn");
        userInfo.setAge(30);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012, 1, 1);
        userInfo.setBirthday(calendar.getTime());

        userInfo.setPhone("15800000000");

        UserInfo friend = new UserInfo();
//        friend.setUserId("wangxiaoxi");
        friend.setUserName("王小喜");
        friend.setPassWord("wangxiaoxi");
//        friend.setEmail("wangxiaoxi@sina.cn");
        friend.setPhone("15811111111");

        userInfo.setFriends(new ArrayList(){{add(friend);}});
    }

    /**
     * 结果打印
     */
    public void print() {
        set.forEach(item -> {
            // 输出验证错误信息
            System.out.println(item.getMessage());
        });

    }

    public void nullValidation() {
        // 使用验证器对对象进行验证
        set = validator.validate(userInfo);
    }

    /**
     * 级联验证测试方法
     */
    public void graphValidation() {
        set = validator.validate(userInfo);
    }

    /**
     * 组序列
     */
    public void groupSequenceValidation() {
        set = validator.validate(userInfo,
                UserInfo.Group.class);
    }

    /**
     * 对方法输入参数进行约束注解校验
     */
    public void paramValidation() throws NoSuchMethodException {
        // 获取校验执行器
        ExecutableValidator executableValidator =
                validator.forExecutables();

        // 待验证对象
        UserInfoService service = new UserInfoService();
        // 待验证方法
        Method method = service.getClass()
                .getMethod("setUserInfo", UserInfo.class);
        // 方法输入参数
        Object[] paramObjects = new Object[]{new UserInfo()};

        // 对方法的输入参数进行校验
        otherSet = executableValidator.validateParameters(
                service,
                method,
                paramObjects);
    }


    /**
     * 对方法返回值进行约束校验
     */
    public void returnValueValidation()
            throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        // 获取校验执行器
        ExecutableValidator executableValidator =
                validator.forExecutables();

        // 构造要验证的方法对象
        UserInfoService service = new UserInfoService();
        Method method = service.getClass()
                .getMethod("getUserInfo");

        // 调用方法得到返回值
        Object returnValue = method.invoke(service);

        // 校验方法返回值是否符合约束
        otherSet = executableValidator.validateReturnValue(
                service,
                method,
                returnValue);
    }

    /**
     * 对构造函数输入参数进行校验
     */
    public void constructorValidation()
            throws NoSuchMethodException {

        // 获取验证执行器
        ExecutableValidator executableValidator =
                validator.forExecutables();

        // 获取构造函数
        Constructor constructor =
                UserInfoService.class
                        .getConstructor(UserInfo.class);
        Object[] paramObjects = new Object[]{new UserInfo()};

        // 校验构造函数
        otherSet = executableValidator
                .validateConstructorParameters(
                        constructor, paramObjects);

    }

    /**
     * 分组验证测试方法
     */
    public void groupValidation() {
        set = validator.validate(userInfo,
                UserInfo.RegisterGroup.class,
                UserInfo.LoginGroup.class);
    }
}
