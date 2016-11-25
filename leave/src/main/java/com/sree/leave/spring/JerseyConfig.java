

package com.sree.leave.spring;


import javax.inject.Named;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import static com.sree.leave.constants.LeaveConstants.BASE_URI;

@Named
@ApplicationPath(BASE_URI)
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("com.sree.leave.controller");
        // register(LeaveRequestController.class);
        // register(LeaveRequestServiceImpl.class);
        // property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}
