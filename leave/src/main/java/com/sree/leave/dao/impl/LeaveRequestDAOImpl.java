package com.sree.leave.dao.impl;


import javax.inject.Named;

import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.FindIterable;
import com.sree.leave.dao.LeaveRequestDAO;
@Named
public class LeaveRequestDAOImpl extends BaseDAO implements LeaveRequestDAO {
 
    @Override
    public FindIterable<Document> getLeaveRequestList(String userId, final Bson projection){
    final Bson filter=and(eq("requestorId",userId),eq("active",true));
    
    FindIterable<Document> leaveRequestDocs=getCollection("leaveRequest").find(filter).projection(projection);
    return leaveRequestDocs;
}
}
