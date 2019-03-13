package com.atom.bas.common;


/***
 * General Result Entity
 *
 * @param <T>
 */
public class Result<T> {
    private String  status;                 // Fail Or Success
    private String  message;                // tips Message
    private T       data;                   // response Object

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
