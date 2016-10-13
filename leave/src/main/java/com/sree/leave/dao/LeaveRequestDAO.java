package com.sree.leave.dao;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;

public interface LeaveRequestDAO {

    FindIterable<Document> getLeaveRequestList(String userId, final Bson projection);

}
