package com.shs.bysj.exception;

/**
 * @Author: shs
 * @Data: 2022/5/2 9:30
 */
public class FileNotExistException extends RuntimeException{
    FileNotExistException() {
        super();
    }
    public FileNotExistException(String message) {
        super(message);
    }
    FileNotExistException(Throwable cause) {
        super(cause);
    }
    FileNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
