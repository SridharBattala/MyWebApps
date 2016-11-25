package com.sree.leave.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sree.leave.exception.LeaveError;
import com.sree.leave.exception.LeaveServiceException;

public class BaseController {
    protected Response handleServerError(LeaveServiceException e){
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(getLeaveErrorObj(e.getErrorCode(),e.getErrorMessage())).build();
        }
    protected Response handleNotFoundError(String errorCode,String errorMessage){
    return Response.status(Status.NOT_FOUND).entity(getLeaveErrorObj(errorCode,errorMessage)).build();
    }
    private LeaveError getLeaveErrorObj(String errorCode,String errorMessage){
        LeaveError leaveError=new LeaveError();
        leaveError.setErrorCode(errorCode);
        leaveError.setErrorMessage(errorMessage);
        return leaveError;
    }
}
