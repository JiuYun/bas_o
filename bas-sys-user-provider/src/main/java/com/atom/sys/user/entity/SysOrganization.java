package com.atom.sys.user.entity;

public class SysOrganization {
    private Long id;                                // 组织机构ID

    private String name;                            // 组织机构名称

    private Long parentId;                          // 上级组织机构ID

    private String parentIds;                       // 父编号

    private Boolean available = Boolean.FALSE;                      // 是否可用

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}