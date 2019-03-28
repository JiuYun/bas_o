package com.atom.message.emuns;

public enum MessageType {

    EMAIL("email",1l),
    PHONE("phone",2L),
    JIGUANG("jiguang",3L),
    UMENG("umeng",4L)

    ;


    MessageType(String name, Long type) {
        this.name = name;
        this.type = type;
    }

    private String  name;
    private Long    type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
