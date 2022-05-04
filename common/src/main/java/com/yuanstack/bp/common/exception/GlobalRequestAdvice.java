package com.yuanstack.bp.common.exception;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hansiyuan
 * @date 2022年03月27日 23:41
 */
@ControllerAdvice
public class GlobalRequestAdvice {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class,
                //true表示转换为日期的字符串可以为空，不设置这个值接收空串会报错
                new CustomDateEditor(dateFormat, true)
        );
    }

}
