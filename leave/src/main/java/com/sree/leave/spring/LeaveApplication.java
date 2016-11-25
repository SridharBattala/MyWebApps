

package com.sree.leave.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "com.sree.leave.*" })
public class LeaveApplication {

    public static void main(final String[] args) {
        SpringApplication.run(LeaveApplication.class, args);
    }
}
