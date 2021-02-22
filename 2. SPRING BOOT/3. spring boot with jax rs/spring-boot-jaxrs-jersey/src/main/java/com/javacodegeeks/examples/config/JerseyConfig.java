package com.javacodegeeks.examples.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.javacodegeeks.examples.service.StudentService;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(StudentService. class);
    }
}
