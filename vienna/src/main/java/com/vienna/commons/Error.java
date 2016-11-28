package com.vienna.commons;

/**
 * @author tonyhui
 * @since 16/11/28
 */
public interface Error {
    int GENERAL_ERROR_CODE = 0;

    String GENERAL_ERROR_MESSAGE = "服务异常";

    /**
     * 获取错误码
     *
     * @return
     */
    int getCode();

    /**
     * 获取错误消息内容
     *
     * @return
     */
    String getMessage();
}
