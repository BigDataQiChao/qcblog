package com.qcblog.config;

/**
 * 没有用到的方法
 *
 * @author 赵起超
 * @date 2019.08.18
 */
public class ServiceException extends Exception {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
