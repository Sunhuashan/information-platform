package com.shs.bysj.exception;

/**
 * @Author: shs
 * @Data: 2022/5/1 15:47
 */
public class FilenameExistException extends RuntimeException{
    public FilenameExistException() {
        super();
    }

    public FilenameExistException(String message) {
        super(message);
    }

    public FilenameExistException(Throwable cause) {
        super(cause);
    }

    public FilenameExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
