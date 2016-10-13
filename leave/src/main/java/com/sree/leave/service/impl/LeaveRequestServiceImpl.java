package com.sree.leave.service.impl;

import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.sree.leave.dao.LeaveRequestDAO;
import com.sree.leave.model.LeaveRequest;
import com.sree.leave.service.LeaveRequestService;
@Named
public class LeaveRequestServiceImpl implements LeaveRequestService{
    private  final LeaveRequestDAO leaveRequestDAO;
    static final Bson GET_LEAVE_REQUEST_LIST_PROJECTION =fields(excludeId(), exclude("active"));

    @Inject
public LeaveRequestServiceImpl(LeaveRequestDAO leaveRequestDAO) {
        
        this.leaveRequestDAO = leaveRequestDAO;
    }

@Override
public List<LeaveRequest> getLeaveRequestList(String userId){
    List<LeaveRequest> leaveRequestList=new ArrayList<>();
    FindIterable<Document> docs=leaveRequestDAO.getLeaveRequestList(userId,GET_LEAVE_REQUEST_LIST_PROJECTION);
    for(Document d:docs){
        LeaveRequest leaveRequest=new LeaveRequest();
        leaveRequest.setId((Double)d.get("id"));
        leaveRequest.setApproverId((String)d.get("approverId"));
        leaveRequest.setApproverName((String)d.get("approverName"));
        leaveRequest.setRequestorName((String)d.get("requestorName"));
        leaveRequest.setRequestorId((String)d.get("requestorId"));
        leaveRequest.setFromDate(((Date)d.get("fromDate")).getTime());
        leaveRequest.setToDate(((Date)d.get("fromDate")).getTime());
        leaveRequest.setReason((String)d.get("reason"));
        leaveRequestList.add(leaveRequest);
    }
    return leaveRequestList;
    
}
}
