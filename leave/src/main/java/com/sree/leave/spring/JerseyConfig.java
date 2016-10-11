package com.sree.leave.spring;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.sree.leave.controller.LeaveRequestController;
@Named
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig() {
        register(LeaveRequestController.class);
       // register(ReverseEndpoint.class);
    }
}
