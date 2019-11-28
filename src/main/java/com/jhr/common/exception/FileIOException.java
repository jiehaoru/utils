package com.jhr.common.exception;

/**
 * <br>
 * 标题：
 * 描述：
 *
 * @author jhr
 * @create 2019/11/28 9:36
 */
public class FileIOException extends Exception {
    public FileIOException() {
    }
    //用详细信息指定一个异常
    public FileIOException(String message) {
        super(message);
    }
    //用指定的详细信息和原因构造一个新的异常
    public FileIOException(String message, Throwable cause) {
        super(message, cause);
    }
    //用指定原因构造一个新的异常
    public FileIOException(Throwable cause) {
        super(cause);
    }

    public FileIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
