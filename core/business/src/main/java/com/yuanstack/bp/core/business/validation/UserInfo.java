package com.yuanstack.bp.core.business.validation;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

/**
 * 待验证对象实体类 用户信息类
 * @author hansiyuan
 * @date 2022年03月28日 23:52
 */
@Data
public class UserInfo {

    // 登录场景
    public interface LoginGroup {}

    // 注册场景
    public interface RegisterGroup {}

    // 组排序场景
    @GroupSequence({
            LoginGroup.class,
            RegisterGroup.class,
            Default.class
    })
    public interface Group {}

    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空",
            groups = LoginGroup.class)
    private String userId;

    /**
     * 用户名
     * NotEmpty 不会自动去掉前后空格
     */
    @NotEmpty(message = "用户名称不能为空")
    private String userName;

    /**
     * 用户密码
     * NotBlank 自动去掉字符串前后空格后验证是否为空
     */
    @NotBlank(message = "用户密码不能为空")
    @Length(min = 6, max = 20,
            message = "密码长度不能少于6位，多于20位")
    private String passWord;

    /**
     * 邮箱
     */
    @NotNull(message = "邮箱不能为空",
            groups = RegisterGroup.class)
    @Email(message = "邮箱必须为有效邮箱")
    private String email;

    /**
     * 手机号
     */
    @Phone(message = "手机号不是158后头随便")
    private String phone;

    /**
     * 年龄
     */
    @Min(value = 18, message = "年龄不能小于18岁")
    @Max(value = 60, message = "年龄不能大于60岁")
    private Integer age;

    /**
     * 生日
     */
    @Past(message = "生日不能为未来或当前时间点")
    private Date birthday;

    /**
     * 好友列表
     */
    @Size(min = 1, message = "不能少于1个好友")
    private List<@Valid UserInfo> friends;
}
