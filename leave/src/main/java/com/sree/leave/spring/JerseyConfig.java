package com.sree.leave.spring;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;

import com.sree.leave.controller.LeaveRequestController;
import com.sree.leave.service.LeaveRequestService;
import com.sree.leave.service.impl.LeaveRequestServiceImpl;
@Named
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig() {
        register(LeaveRequestController.class);
        //register(LeaveRequestServiceImpl.class);
    }
}
