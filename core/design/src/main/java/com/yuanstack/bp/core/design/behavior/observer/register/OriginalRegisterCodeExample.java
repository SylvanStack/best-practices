package com.yuanstack.bp.core.design.behavior.observer.register;

/**
 * @description: 待重构的注册代码片段举例
 * @author: hansiyuan
 * @date: 2022/3/29 4:18 PM
 */
public class OriginalRegisterCodeExample {
    // 依赖注入
    private UserService userService = new UserService();
    // 依赖注入
    private PromotionService promotionService = new PromotionService();
    public Long register(String telephone, String password){
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        System.out.println("注册用户主逻辑");
        long userId = userService.register(telephone, password);
        promotionService.issueNewUserExperienceCash(userId);
        return userId;
    }
}
