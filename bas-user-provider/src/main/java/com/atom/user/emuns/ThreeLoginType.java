package com.atom.user.emuns;

public enum ThreeLoginType {

    WeChat("微信",1)


    ;


    private String  name;
    private int     value;

    ThreeLoginType(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
