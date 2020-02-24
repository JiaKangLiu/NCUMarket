package com.newMedia.enums;

public enum UserStateEnum {
    REGISTRY_SUCCESS(4, "注册成功"),
    LOGIN_SUCCESS(3, "登录成功"),
    Query_SUCCESS(2, "查询成功"),
    NO_USER(1, "无该用户"),
    INNER_ERROR(0, "内部错误"),
    REPEAT_MAIL(-1, "重复邮箱"),
    REPEAT_PHONE(-2, "重复手机号"),
    WRONG_FORM(-3, "手机或邮箱格式错误"),
    WRONG_PWD(-100, "密码错误");


    private int state;
    private String stateInfo;

    UserStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static UserStateEnum stateof(int index) {
        for (UserStateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
