

package com.sree.leave.service.impl;


import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.client.FindIterable;
import com.sree.leave.dao.LeaveRequestDAO;
import com.sree.leave.exception.LeaveDaoException;
import com.sree.leave.exception.LeaveServiceException;
import com.sree.leave.model.LeaveRequest;
import com.sree.leave.service.LeaveRequestService;
import com.sree.leave.util.LeaveRequestUtil;


@Named
public class LeaveRequestServiceImpl implements LeaveRequestService {
    private final static Logger LOGGER=LoggerFactory.getLogger(LeaveRequestServiceImpl.class);
    private final LeaveRequestDAO leaveRequestDAO;
    static final Bson GET_LEAVE_REQUEST_LIST_PROJECTION = fields(excludeId(), exclude("active"));
    @Inject
    public LeaveRequestServiceImpl(final LeaveRequestDAO leaveRequestDAO) {

        this.leaveRequestDAO = leaveRequestDAO;
    }

    @Override
    public List<LeaveRequest> getLeaveRequestList(final String userId) throws LeaveServiceException{
        
        try{
            final List<LeaveRequest> leaveRequestList = new ArrayList<>();
            final FindIterable<Document> docs = leaveRequestDAO.getLeaveRequestList(userId, GET_LEAVE_REQUEST_LIST_PROJECTION);
            for (final Document d : docs) {
                final LeaveRequest leaveRequest = new LeaveRequest();
                leaveRequest.setId((String)d.get("_id"));
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
        } catch(final LeaveDaoException e) {
            LOGGER.error("Exception while getting leave request list",e);
            throw new LeaveServiceException("Exception while getting leave request list",e);
        }
    }

    @Override
    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) throws LeaveServiceException{
    	 try{
    	      Document doc=new Document();
    	      String id= LeaveRequestUtil.generateLeaveRequestId(leaveRequest.getRequestorId(), leaveRequest.getFromDate(), leaveRequest.getToDate());
    	        doc.put("_id", id);
    	        doc.put("fromDate",  leaveRequest.getFromDate());
    	        doc.put("toDate",  leaveRequest.getToDate());
    	        doc.put("requestorName",  leaveRequest.getRequestorName());
    	        doc.put("requestorId",  leaveRequest.getRequestorId());
    	        doc.put("approverId",  leaveRequest.getApproverId());
    	        doc.put("approverName",  leaveRequest.getApproverName());
    	        doc.put("reason",  leaveRequest.getReason());
    	        doc.put("active",  true);
    	        Bson filter=eq("_id",id);
    	        leaveRequestDAO.saveLeaveRequest(filter, doc);
    	 }catch(final LeaveDaoException e) {
             LOGGER.error("Exception while getting leave request list",e);
             throw new LeaveServiceException("Exception while getting leave request list",e);
         }

  return leaveRequest;

    }

    @Override
    public LeaveRequest getLeaveRequest(String id) throws LeaveServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LeaveRequest updateLeaveRequest(LeaveRequest leaveRequest) throws LeaveServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteLeaveRequest(String leaveRequestId) throws LeaveServiceException {
        // TODO Auto-generated method stub
        
    }
}
