package com.atom.user.pojo;


import com.atom.bas.common.Result;
import com.atom.bas.common.ResultUtil;
import com.atom.bas.common.exception.MsgException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalDefaultExceptionHandler {



    @ExceptionHandler(MsgException.class)
    public Object defaultExceptionHandler(HttpServletRequest request, HttpServletResponse response,Exception e){
        return ResultUtil.fail(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidException(HttpServletRequest request,HttpServletResponse response,MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        return ResultUtil.fail(result.getFieldError().getDefaultMessage(),null);
    }




}
