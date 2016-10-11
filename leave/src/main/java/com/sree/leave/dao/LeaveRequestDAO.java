package com.sree.leave.dao;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public interface LeaveRequestDAO {

    FindIterable<Document> getLeaveRequestList(String userId);

}
