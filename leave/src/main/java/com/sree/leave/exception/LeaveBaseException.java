package com.sree.leave.exception;

public class LeaveBaseException extends Exception{

    private static final long serialVersionUID = -4031781112304642639L;
    private final String errorCode;
    private final String errorMessage;
    public LeaveBaseException(String errorCode, String errorMessage, Exception e) {
        super(errorMessage,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public LeaveBaseException(String errorMessage,Exception e) {
        super(errorMessage,e);
        this.errorCode = null;
        this.errorMessage = errorMessage;
        
    }
    public LeaveBaseException(String errorCode,String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    public String getErroCode(){
        return this.errorCode;
    }
    public String getErroMessage(){
        return this.errorMessage;
    }
}
