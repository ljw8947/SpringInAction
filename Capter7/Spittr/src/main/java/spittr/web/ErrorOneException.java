package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jwlv on 2017/11/28.
 */
//将异常映射为特定的状态码
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "将异常映射为特定的状态码")
public class ErrorOneException extends Exception {

}
