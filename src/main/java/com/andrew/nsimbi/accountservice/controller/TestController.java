package com.andrew.nsimbi.accountservice.controller;

import com.andrew.nsimbi.accountservice.configuration.Configuration;
import com.andrew.nsimbi.accountservice.configuration.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Configuration configuration;

    @GetMapping
    public String getMessage(){
        return "This is the git versioned Nsimbi app - account service";
    }

    @GetMapping(value = "/config")
    public LimitConfiguration getConfigs(){
        return new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }
}
