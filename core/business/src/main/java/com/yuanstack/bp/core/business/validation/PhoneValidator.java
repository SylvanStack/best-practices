package com.yuanstack.bp.core.business.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自定义手机号约束注解关联验证器
 *
 * @author hansiyuan
 * @date 2022年03月28日 23:51
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    /**
     * 自定义校验逻辑方法
     *
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {

        // 手机号验证规则：158后头随便
        String check = "158\\d{8}";
        Pattern regex = Pattern.compile(check);

        // 空值处理
        String phone = Optional.ofNullable(value).orElse("");
        Matcher matcher = regex.matcher(phone);

        return matcher.matches();
    }
}
