package com.sree.leave.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.client.FindIterable;
import com.sree.leave.dao.LeaveRequestDAO;
import com.sree.leave.model.LeaveRequest;
import com.sree.leave.service.LeaveRequestService;
@Component
public class LeaveRequestServiceImpl implements LeaveRequestService{
   /* @Inject
public LeaveRequestServiceImpl(LeaveRequestDAO leaveRequestDAO) {
        
        this.leaveRequestDAO = leaveRequestDAO;
    }*/
@Autowired
private  LeaveRequestDAO leaveRequestDAO;
@Override
public List<LeaveRequest> getLeaveRequestList(String userId){
    List<LeaveRequest> leaveRequestList=new ArrayList<>();
    FindIterable<Document> docs=leaveRequestDAO.getLeaveRequestList(userId);
    for(Document d:docs){
        LeaveRequest leaveRequest=new LeaveRequest();
        leaveRequest.setId((String)d.get("id"));
        leaveRequestList.add(leaveRequest);
    }
    return leaveRequestList;
    
}
}
