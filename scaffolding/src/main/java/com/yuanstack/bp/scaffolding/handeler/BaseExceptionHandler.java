package com.yuanstack.bp.scaffolding.handeler;

import com.yuanstack.bp.scaffolding.common.base.ResponseDTO;
import com.yuanstack.bp.scaffolding.common.expection.BaseException;
import com.yuanstack.bp.scaffolding.common.expection.BaseExceptionType;
import com.yuanstack.bp.scaffolding.common.expection.ModelViewException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 异常处理器
 * @author: hansiyuan
 * @date: 2022/3/4 2:54 PM
 */
@ControllerAdvice
public class BaseExceptionHandler {
    /**
     * 处理程序员主动转换的自定义异常
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseDTO customException(BaseException e) {
        if (e.getCode() == BaseExceptionType.SYSTEM_ERROR.getCode()) {
            //400异常不需要持久化，将异常信息以友好的方式告知用户就可以
            //TODO 将500异常信息持久化处理，方便运维人员处理
        }
        return ResponseDTO.error(e);
    }

    /**
     * 处理程序员在程序中未能捕获（遗漏的）异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseDTO exception(Exception e) {
        //TODO 将异常信息持久化处理，方便运维人员处理

        return ResponseDTO.error(new BaseException(
                BaseExceptionType.OTHER_ERROR));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseDTO handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return ResponseDTO.error(new BaseException(BaseExceptionType.USER_INPUT_ERROR,
                fieldError.getDefaultMessage()));
    }


    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseDTO handleBindException(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return ResponseDTO.error(new BaseException(BaseExceptionType.USER_INPUT_ERROR,
                fieldError.getDefaultMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseDTO handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseDTO.error(
                new BaseException(BaseExceptionType.USER_INPUT_ERROR,
                        e.getMessage())
        );
    }

    @ExceptionHandler(ModelViewException.class)
    public ModelAndView viewExceptionHandler(HttpServletRequest req, ModelViewException e) {
        ModelAndView modelAndView = new ModelAndView();

        //将异常信息设置如modelAndView
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", req.getRequestURL());
        modelAndView.setViewName("error");

        //返回ModelAndView
        return modelAndView;
    }
}
