package com.vienna.commons;

/**
 * 服务异常类
 *
 */
public class ServiceException extends CommonException {

    /**
     * @param message
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
