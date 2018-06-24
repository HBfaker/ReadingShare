package edu.bupt.config;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 73681 on 2018/6/23.
 * control层异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = Logger.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error(e.getMessage());
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMsg(e.getMessage());
        //如果是token错误，需要重新登录，返回状态码900，
        r.setCode(e.getMessage().equals("tokenError")? ErrorInfo.NeedLoginERROR : ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
