package com.sree.leave.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sree.leave.model.LeaveRequest;
import com.sree.leave.service.LeaveRequestService;
import com.sree.leave.service.impl.LeaveRequestServiceImpl;
@Named
//@Component
@Path("/api/v1/leave")
public class LeaveRequestController {
    //@Autowired
    private  final LeaveRequestService leaveRequestService;
    @Inject
    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        
        this.leaveRequestService = leaveRequestService;
    }
    @GET
    @Path("/{userId}"+"/leaveRequestList")
    @Produces(MediaType.APPLICATION_JSON)
    
public Response getLeaveRequestList(@PathParam("userId") String userId){
    return Response.ok().entity(leaveRequestService.getLeaveRequestList(userId)).build();
    
}
    
}
