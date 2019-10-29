package com.caoyong.programs.aop;

import com.caoyong.base.bean.BaseResponse;
import com.caoyong.commons.exceptions.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局的的异常拦截器
 *
 * @author caoyong
 * @version 1.0.0
 * @since 2019-10-29 15:53
 **/
@ControllerAdvice
@Order(-1)
@Slf4j
public class GlobalExceptionHandler<T> {
    /**
     * 拦截业务异常
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public BaseResponse<T> business(HttpServletRequest request, BizException e) {
        BaseResponse<T> result = new BaseResponse<>();
        String uri = request.getRequestURI();
        log.error(uri + " biz error:{}", e.getMessage(), e);
        result.setMsg(e.getMessage());
        result.setCode(e.getErrorCode());
        result.setSuccess(false);
        return result;
    }
}
