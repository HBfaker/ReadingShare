package edu.bupt.exception;

/**
 * Created by 73681 on 2018/6/23.
 */
public class ServiceException extends BaseException{
    public ServiceException(String errorCode, Exception e) {
        super(errorCode, e);
    }

    public ServiceException(Exception e) {
        super(e);
    }

    public ServiceException(String errorCode) {
        super(errorCode);
    }

    public ServiceException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ServiceException(Exception e, String errorCode, String errorMessage) {
        super(e, errorCode, errorMessage);
    }
}
