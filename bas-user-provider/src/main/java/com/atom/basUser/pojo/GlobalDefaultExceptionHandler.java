package com.atom.basUser.pojo;


import com.atom.bas.common.exception.MsgException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalDefaultExceptionHandler {



    @ExceptionHandler(MsgException.class)
    public Object defaultExceptionHandler(HttpServletRequest request, HttpServletResponse response,Exception e){

        System.out.println(String.format("时间：%s发生错误%s",System.currentTimeMillis(),e.getLocalizedMessage()));

        return new HashMap<String,Object>(){{
            put("msg","系统错误");
            put("code","-10");
        }};
    }






}
