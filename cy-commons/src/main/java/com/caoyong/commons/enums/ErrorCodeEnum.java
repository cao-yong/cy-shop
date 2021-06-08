package com.caoyong.commons.enums;

import java.util.stream.Stream;

/**
 * 错误枚举
 *
 * @author caoyong
 * @since 2018年1月29日 上午11:34:26
 */
public enum ErrorCodeEnum {

    UNKNOWN_ERROR("500", "未知错误"),

    SERVICE_SAVE_ERROR("2001", "Service保存失败"),
    SERVICE_UPDATE_ERROR("2002", "Service更新失败"),
    SERVICE_BATCH_SAVE_ERROR("2003", "Service批量保存失败"),
    SERVICE_QUERY_ERROR("2003", "Service查询失败"),
    PASSWORD_IS_ERROR("2004", "密码不正确"),
    OPERATION_NOT_EXIST("2005", "操作类型不存在"),
    PRIMARY_KEY_NOT_EXIST("2006", "主键不存在"),

    SUCCESS("200", "成功"),
    QUERY_ERROR("301", "查询失败"),
    QUERY_DATA_NOT_EXIST("302", "相关数据不存在"),
    QUERY_DATA_IS_EXIST("304", "相关数据已存在"),
    USER_NOT_EXIST("001", "用户不存在"),
    NO_LOGIN_ERROR("000", "未登录");

    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 获得枚举
     *
     * @param code
     * @return
     */
    public static ErrorCodeEnum getEnum(String code) {
        return Stream.of(ErrorCodeEnum.values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }
}
