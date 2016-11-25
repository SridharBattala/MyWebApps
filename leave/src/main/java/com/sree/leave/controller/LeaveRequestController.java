

package com.sree.leave.controller;


import static com.sree.leave.constants.LeaveConstants.LEAVE_REQUEST;
import static com.sree.leave.constants.LeaveConstants.LEAVE_REQUEST_ID;
import static com.sree.leave.constants.LeaveConstants.USER_ID;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sree.leave.dao.impl.LeaveRequestDAOImpl;
import com.sree.leave.exception.LeaveServiceException;
import com.sree.leave.model.LeaveRequest;
import com.sree.leave.service.LeaveRequestService;

@Named
public class LeaveRequestController extends BaseController{
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
                return handleNotFoundError("Leave.101", "No Leave request found for the user");
            } else {
                return Response.ok().entity(leaveRequestList).build();
            }
           
        } catch(LeaveServiceException e){
            LOGGER.error("Exception while getting leave request list",e);
            return handleServerError(e);
        }
       

    }
    @POST
    @Path( LEAVE_REQUEST)
    @Produces(MediaType.APPLICATION_JSON)

    public Response createLeaveRequest(LeaveRequest leaveRequest) {
        try{
            //TO-DO need to handle for other parameters also
            if(leaveRequest.getRequestorId()!=null){
                return handlePreConditionError("Leave.102", "RequestorId can't be empty for creating new leave request");         
            }
             leaveRequest=leaveRequestService.createLeaveRequest(leaveRequest);
             return Response.status(Status.CREATED).entity(leaveRequest).build();
           
        } catch(LeaveServiceException e){
            LOGGER.error("Exception while creating leave request",e);
            return handleServerError(e);
        }
       

    }
    @PUT
    @Path( LEAVE_REQUEST+"/{"+LEAVE_REQUEST_ID+"}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response updateLeaveRequest(@PathParam("leaveRequestId") Long leaveRequestId,LeaveRequest leaveRequest) {
        try{
            //TO-DO need to handle for other parameters also
            if(leaveRequestId==null){
                return handlePreConditionError("Leave.102", "Leave Request Id can't be empty for updating leave request");                
            }
            LeaveRequest leaveRequestOld=leaveRequestService.getLeaveRequest(leaveRequestId);
            if(leaveRequestOld==null) {
                return handleNotFoundError("Leave.101", "No Leave request found for the user");
            }
            leaveRequest.setId(leaveRequestId);
             leaveRequest=leaveRequestService.updateLeaveRequest(leaveRequest);
             return Response.status(Status.OK).entity(leaveRequest).build();
           
        } catch(LeaveServiceException e){
            LOGGER.error("Exception while updating leave request",e);
            return handleServerError(e);
        }
       

    }
    @DELETE
    @Path( LEAVE_REQUEST+"/{"+LEAVE_REQUEST_ID+"}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response deleteLeaveRequest(@PathParam("leaveRequestId") Long leaveRequestId,LeaveRequest leaveRequest) {
        try{
            //TO-DO need to handle for other parameters also
            if(leaveRequestId==null){               
                return handleNotFoundError("Leave.101","Leave Request Id can't be empty for deleting leave request");
            }
            LeaveRequest leaveRequestOld=leaveRequestService.getLeaveRequest(leaveRequest.getId());
            if(leaveRequestOld==null) {
                return handleNotFoundError("Leave.101","No Leave request found for the user");
            }
             leaveRequestService.deleteLeaveRequest(leaveRequestId);
             return Response.status(Status.NO_CONTENT).build();
           
        } catch(LeaveServiceException e){
            LOGGER.error("Exception while updating leave request",e);
            return handleServerError(e);
        }
       

    }
}
