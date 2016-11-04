package com.sree.leave.spring;

import javax.inject.Named;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;

import com.sree.leave.controller.LeaveRequestController;
@Named
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig() {
        packages("com.sree.leave.controller");
        //register(LeaveRequestController.class);
        //register(LeaveRequestServiceImpl.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}
