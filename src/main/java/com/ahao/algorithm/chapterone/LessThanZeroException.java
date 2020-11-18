package com.ahao.algorithm.chapterone;

/**
 * @author ahao
 */
public class LessThanZeroException extends RuntimeException {
    public LessThanZeroException() {
        System.out.println("数不能小于0");
    }

    public LessThanZeroException(String message) {
        super(message);
    }

    public LessThanZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public LessThanZeroException(Throwable cause) {
        super(cause);
    }

    protected LessThanZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
