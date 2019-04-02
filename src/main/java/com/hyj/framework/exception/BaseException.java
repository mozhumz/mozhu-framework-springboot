package com.hyj.framework.exception;

/**
 * @author huyuanjia
 * @date 2019/4/2 16:30
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -8170023045088441807L;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
