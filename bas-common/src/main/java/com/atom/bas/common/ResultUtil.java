package com.atom.bas.common;

public class ResultUtil {


    public static Result success(String message,Object data){
        return new Result(message,data);
    }

    public static Result success(Object data){
        return new Result("",data);
    }


    public static Result fail(Exception e) {
        Result result = new Result();
        result.setStatus("fall");
        result.setMessage(e.getLocalizedMessage());
        return result;
    }


    public static Result fail(String message,Object data){
        Result result = new Result();
        result.setStatus("fall");
        result.setMessage(message);
        return result;
    }


}
