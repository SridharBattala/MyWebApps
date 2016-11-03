package com.sree.leave.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
@Named
public class BaseDAO {
    @Inject
    private  MongoClient mongoClient;
    
    
    protected MongoCollection<Document> getCollection(String collectionName){
        return mongoClient.getDatabase("local").getCollection(collectionName);
    }
}
