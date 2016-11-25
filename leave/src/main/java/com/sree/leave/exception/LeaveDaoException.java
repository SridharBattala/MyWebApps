package com.sree.leave.exception;

public class LeaveDaoException extends LeaveBaseException{

    
    private static final long serialVersionUID = -723852264622453353L;

    public LeaveDaoException(String errorCode, String errorMessage, Exception e) {
        super(errorMessage,e);    
    }
    public LeaveDaoException(String errorCode,String errorMessage) {
        super(errorCode,errorMessage);   
    }
    public LeaveDaoException(String errorMessage, Exception e) {
        super(errorMessage, e);
    }
}
