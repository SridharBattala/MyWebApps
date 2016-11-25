

package com.sree.leave.controller;


import static com.sree.leave.constants.LeaveConstants.LEAVE_REQUEST;
import static com.sree.leave.constants.LeaveConstants.USER_ID;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sree.leave.dao.impl.LeaveRequestDAOImpl;
import com.sree.leave.exception.LeaveBaseException;
import com.sree.leave.exception.LeaveError;
import com.sree.leave.exception.LeaveServiceException;
import com.sree.leave.model.LeaveRequest;
import com.sree.leave.service.LeaveRequestService;

@Named
public class LeaveRequestController {
    private final LeaveRequestService leaveRequestService;
    private final static Logger LOGGER=LoggerFactory.getLogger(LeaveRequestDAOImpl.class);
    @Inject
    public LeaveRequestController(final LeaveRequestService leaveRequestService) {

        this.leaveRequestService = leaveRequestService;
    }

    @GET
    @Path(LEAVE_REQUEST+"/{"+USER_ID+"}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response getLeaveRequestList(@PathParam("userId") final String userId) {
        try{
            List<LeaveRequest> leaveRequestList=leaveRequestService.getLeaveRequestList(userId);
            if(leaveRequestList.isEmpty()) {
                LeaveError leaveError=new LeaveError();
                leaveError.setErrorCode("Leave.101");
                leaveError.setErrorMessage("No Leave request found for the user");
                return Response.status(Status.NOT_FOUND).entity(leaveError).build();
            } else {
                return Response.ok().entity(leaveRequestList).build();
            }
           
        } catch(LeaveServiceException e){
            LOGGER.error("Exception while getting leave request list",e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new LeaveBaseException(e.getErroCode(),e.getMessage())).build();
        }
       

    }
    @POST
    @Path( LEAVE_REQUEST)
    @Produces(MediaType.APPLICATION_JSON)

    public Response createLeaveRequest(LeaveRequest leaveRequest) {
        try{
            //TO-DO need to handle for other parameters also
            if(leaveRequest.getRequestorId()!=null){
                LeaveError leaveError=new LeaveError();
                leaveError.setErrorCode("Leave.102");
                leaveError.setErrorMessage("RequestorId can't be empty for creating new leave request");
                return Response.status(Status.PRECONDITION_FAILED).entity(leaveError).build();
            }
             leaveRequest=leaveRequestService.createLeaveRequest(leaveRequest);
             return Response.status(Status.CREATED).entity(leaveRequest).build();
           
        } catch(LeaveServiceException e){
            LeaveError leaveError=new LeaveError();
            leaveError.setErrorCode(e.getErroCode());
            leaveError.setErrorMessage(e.getErroMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(leaveError).build();
        }
       

    }

}
