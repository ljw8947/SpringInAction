package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by jwlv on 2017/11/29.
 */
//处理应用范围内的异常
@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(ErrorThreeException.class)
    public String errorThreeExceptionHandler(){
        return "error";
    }
}
