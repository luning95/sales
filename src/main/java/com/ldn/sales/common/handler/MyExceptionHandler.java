package com.ldn.sales.common.handler;

import com.ldn.sales.common.ResultDto;
import com.ldn.sales.common.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private ResultDto handler(Exception e) {
        if (e instanceof MyException) {

            MyException myE=(MyException)e;
            ResultDto resultDto = new ResultDto(false, myE.getErrorCode(), myE.getMessage(), "");
            return resultDto;
        } else {
            ResultDto resultDto = new ResultDto(false, -1, e.getMessage(), "");
            return resultDto;

        }


    }

 /*   @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private ResultDto handler(Exception e) {
        ResultDto resultDto = new ResultDto(false, 2, e.getMessage(), "");
        return resultDto;
    }*/
}
