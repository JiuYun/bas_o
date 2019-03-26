package com.atom.user.dto;

import javax.validation.constraints.Null;

public class BindWeChat {

    @Null(message = "微信code不能为空")
    private String  code;               // 微信code
    @Null(message = "用户ID不能为空")
    private Long    userId;             // 用户ID

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
