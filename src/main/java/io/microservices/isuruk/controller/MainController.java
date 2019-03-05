package io.microservices.isuruk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(path = "/api/micro")
    public String appRunning(){
        return "microservice.io";
    }
}
