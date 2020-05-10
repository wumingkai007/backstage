package com.wuxiaotian.globalexception;


import com.wuxiaotian.util.JsonResult;
import com.wuxiaotian.util.ResponseCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author: wumingkai
 * @Description:全局异常处理
 * @Date:Create：in 2020/3/29 21:37
 * @Modified By：
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 运行时异常
     * @param exception
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult<String> runtimeException(RuntimeException exception){
        exception.printStackTrace();
        return handleErrorInfo(exception.getMessage());
    }

    /**
     * 其他异常
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult<String> exceptionHandler(Exception exception){
        exception.printStackTrace();
        return handleErrorInfo(exception.getMessage());
    }

    private JsonResult<String> handleErrorInfo(String message) {
        JsonResult<String> errorMessage = new JsonResult<>(ResponseCode.ERROR);
        errorMessage.setMsg(message);
        return errorMessage;
    }
}
