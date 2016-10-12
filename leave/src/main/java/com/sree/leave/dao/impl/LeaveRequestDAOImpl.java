package com.sree.leave.dao.impl;


import javax.inject.Named;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.sree.leave.dao.LeaveRequestDAO;
@Named
public class LeaveRequestDAOImpl extends BaseDAO implements LeaveRequestDAO {
 
    @Override
    public FindIterable<Document> getLeaveRequestList(String userId){
    MongoCollection<Document> mongoCollection=getCollection("leaveRequest");
    FindIterable<Document> leaveRequestDocs=mongoCollection.find();
    return leaveRequestDocs;
}
}
