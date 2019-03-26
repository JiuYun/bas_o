package com.atom.user.dto;

import javax.validation.constraints.Null;

public class PhoneExist {

    @Null(message = "手机号不能为空")
    private String  phone;          // 手机号
    private Long    userId;         // 用户ID


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
