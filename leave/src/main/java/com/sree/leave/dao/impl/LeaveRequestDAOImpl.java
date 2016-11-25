

package com.sree.leave.dao.impl;


import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import javax.inject.Named;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.sree.leave.dao.LeaveRequestDAO;
import com.sree.leave.exception.LeaveDaoException;


@Named
public class LeaveRequestDAOImpl extends BaseDAO implements LeaveRequestDAO {
    private final static Logger LOGGER=LoggerFactory.getLogger(LeaveRequestDAOImpl.class);
    @Override
    public FindIterable<Document> getLeaveRequestList(final String userId, final Bson projection)  throws LeaveDaoException{
        try{
            final Bson filter = and(eq("requestorId", userId), eq("active", true));
            final FindIterable<Document> leaveRequestDocs = getCollection("leaveRequest").find(filter).projection(projection);
            return leaveRequestDocs;
        } catch(MongoException e){
            LOGGER.error("Exception while getting leave request list",e);
            throw new LeaveDaoException("Exception while getting leave request list",e);
        }
       
    }
}
