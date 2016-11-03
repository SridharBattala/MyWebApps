package com.sree.leave.spring;

import javax.inject.Named;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.sree.leave.controller.LeaveRequestController;
@Named
//@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig() {
        register(LeaveRequestController.class);
        //register(LeaveRequestServiceImpl.class);
    }
}
