package com.atom.bas.common;


/***
 * General Result entity
 *
 * @param <T>
 */
public class Result<T> {
    private String  status;                 // fail Or success
    private String  message;                // tips Message
    private T       data;                   // response Object


    public Result(String message, T data) {
        this.status = "success";
        this.message = message;
        this.data = data;
    }

    public Result() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }





}
