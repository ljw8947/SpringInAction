package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jwlv on 2017/11/28.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "全局异常")
public class ErrorThreeException extends Exception {
    public ErrorThreeException(){
        super("全局异常");
    }
}
