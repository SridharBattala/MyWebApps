package com.sree.leave.service;

import java.util.List;

import com.sree.leave.model.LeaveRequest;

public interface LeaveRequestService {

    List<LeaveRequest> getLeaveRequestList(String userId);

}
