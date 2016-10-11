package com.sree.leave.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sree.leave.dao.LeaveRequestDAO;
@Component
public class LeaveRequestDAOImpl implements LeaveRequestDAO{
    /*@Inject
    public LeaveRequestDAOImpl(MongoCollection<Document> mongoCollection) {
        super();
        this.mongoCollection = mongoCollection;
    }*/
    //@Autowired
    //private MongoCollection<Document> mongoCollection;
    @Override
    public FindIterable<Document> getLeaveRequestList(String userId){
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("local");
        MongoCollection<Document> mongoCollection=database.getCollection("leaveRequest");
    FindIterable<Document> leaveRequestDocs=mongoCollection.find();
    //mongoClient.close();
    return leaveRequestDocs;
    
}
}
