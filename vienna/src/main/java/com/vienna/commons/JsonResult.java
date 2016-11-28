package com.vienna.commons;

import lombok.Data;

/**
 * @author tonyhui
 * @since 16/11/28
 */
@Data
public class JsonResult<T> {

    private boolean success;

    private T data;

    private Integer errorCode;

    private String errorMessage;

    public static <T> JsonResult<T> ok() {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(true);
        return result;
    }

    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> JsonResult<T> error() {
        return error(Error.GENERAL_ERROR_CODE, Error.GENERAL_ERROR_MESSAGE);
    }

    public static <T> JsonResult<T> error(Error error) {
        return error(error.getCode(), error.getMessage());
    }

    private static <T> JsonResult<T> error(Integer errorCode, String errorMessage) {
        JsonResult<T> result = new JsonResult<>();
        result.setErrorCode(errorCode);
        result.setErrorMessage(errorMessage);
        return result;
    }

}
