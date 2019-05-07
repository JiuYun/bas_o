package com.atom.sys.user.entity;

public class SysRole {
    private Long id;                        // 编号

    private String role;                    // 角色标识 程序中判断使用,如"admin"

    private String description;             // 角色描述,UI界面显示使用

    private String resourceIds;             // 拥有的资源

    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}