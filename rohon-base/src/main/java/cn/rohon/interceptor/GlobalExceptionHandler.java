package cn.rohon.interceptor;

import cn.rohon.config.Const;
import cn.rohon.exception.MyException;
import cn.rohon.utils.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 缺少请求参数异常
     * @param ex HttpMessageNotReadableException
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResultData handleHttpMessageNotReadableException(
            MissingServletRequestParameterException ex) {
        logger.error("缺少请求参数，{}", ex.getMessage());
        return ResultData.converResullt(false,"缺少请求参数");
    }

    /**
     * 业务异常
     * @param ex HttpMessageNotReadableException
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResultData handleBusinessException(MyException ex) {
        logger.error("业务异常，{}", ex.getMessage());
        return ResultData.converResullt(false,ex.getMessage());
    }
}
