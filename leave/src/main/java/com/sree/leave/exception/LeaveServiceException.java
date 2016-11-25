package com.sree.leave.exception;

public class LeaveServiceException extends LeaveBaseException{

    private static final long serialVersionUID = 7098811913327229832L;
    public LeaveServiceException(String errorCode, String errorMessage, Exception e) {
        super(errorMessage,e);    
    }
    public LeaveServiceException(String errorCode,String errorMessage) {
        super(errorCode,errorMessage);   
    }
    public LeaveServiceException(String errorMessage, Exception e) {
        super(errorMessage, e);
    }
}
