package com.atom.bas.common.exception;

public class MsgException extends RuntimeException {

    private Integer code;

    private Object data;

    public MsgException(String msg,Integer code,Object data){
        super(msg);
        this.code = code;
        this.data = data;
    }

    public MsgException(String msg,Object data){
        super(msg);
        this.code = -1;
        this.data = data;
    }

    public MsgException(String msg){
        super(msg);
        this.code = -1;
    }









}
