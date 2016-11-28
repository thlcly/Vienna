package com.vienna.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tonyhui
 * @since 16/11/28
 */
@Getter
@AllArgsConstructor
public enum  ApiError implements Error {
    //系统错误
    GENERAL_ERR(0, "服务异常"),
    GENERAL_JSON_CONVERT_ERR(1, "数据格式错误"),
    GENERAL_NEED_AUTH(2, "需要授权"),
    GENERAL_CONNECT_TIMEOUT(3, "连接超时"),

    // 用户模块错误
    USER_MD5_ENCRYPT_FAIL(10, "md5加密失败"),
    USER_DELETE_FAIL(11, "删除用户出错");

    private int code;
    private String message;
}
