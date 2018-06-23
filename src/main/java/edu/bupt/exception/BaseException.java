package edu.bupt.exception;

/**
 * Created by 73681 on 2018/6/23.
 */
public class BaseException {
    private static final long serialVersionUID = -4368304810297242836L;

    private String errorCode;

    private Exception exception;

    private String errorMessage;

    /**
     * @param e which cause exception
     * @param errorCode which is defined in @ErrorCodeUtil
     */
    public BaseException(String errorCode,Exception e) {
        this.errorCode = errorCode;
        this.exception = e;
    }

    public BaseException(Exception e) {
        this.exception = e;
    }

    public BaseException(String errorCode) {
        this.errorCode = errorCode;
    }

    public BaseException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseException(Exception e, String errorCode, String errorMessage) {
        this.exception = e;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * @description errorCode which is defined in @ErrorCodeUtil
     * @author Jay He
     * @time Sep 28, 2015 10:34:15 AM
     * @return String
     */
    public String getErrorCode() {
        return errorCode;
    }

    public Exception getException() {
        return exception;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
