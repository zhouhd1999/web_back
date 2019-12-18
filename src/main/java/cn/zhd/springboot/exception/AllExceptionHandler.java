package cn.zhd.springboot.exception;

import cn.zhd.springboot.enums.ResultEnum;
import cn.zhd.springboot.util.Msg;
import cn.zhd.springboot.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class AllExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Msg<Object> handlerExceptionHandler(HttpServletRequest request, Exception e)
    {
        log.error("【统一异常处理】 请求地址： request=" + request.getRequestURI());
        log.error("【统一异常处理】 异常信息："+e);
        e.printStackTrace();
        return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
    }


}
