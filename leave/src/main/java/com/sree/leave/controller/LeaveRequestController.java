package com.sree.leave.controller;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.sree.leave.model.LeaveRequest;
@Named
@Path("/api/v1/leave")
public class LeaveRequestController {
    @GET
    @Path("/{userId}"+"/leaveRequests")
    @Produces("application/json")
public Response getLeaveRequests(){
    return Response.ok().entity(new LeaveRequest()).build();
    
}
}
