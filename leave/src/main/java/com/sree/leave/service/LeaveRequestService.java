

package com.sree.leave.service;


import java.util.List;

import com.sree.leave.exception.LeaveServiceException;
import com.sree.leave.model.LeaveRequest;


public interface LeaveRequestService {

    List<LeaveRequest> getLeaveRequestList(String userId) throws LeaveServiceException;

    LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) throws LeaveServiceException;

    LeaveRequest getLeaveRequest(String id) throws LeaveServiceException;

    LeaveRequest updateLeaveRequest(LeaveRequest leaveRequest) throws LeaveServiceException;

    void deleteLeaveRequest(String leaveRequestId) throws LeaveServiceException;

}
