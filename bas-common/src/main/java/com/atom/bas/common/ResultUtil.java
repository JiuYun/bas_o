package com.atom.bas.common;

public class ResultUtil {


    public static Result success(String message,Object data){
        return new Result(message,data);
    }

    public static Result success(Object data){
        return new Result("",data);
    }


}
