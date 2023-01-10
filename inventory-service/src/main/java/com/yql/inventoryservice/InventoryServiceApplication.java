package com.yql.inventoryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/inventory")
@RestController
@SpringBootApplication
public class InventoryServiceApplication {
    @Autowired
    Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @GetMapping
    public String get() {
        return "This is inventory service:" + environment.getProperty("server.port");
    }

    @GetMapping("/deduct")
    public String deduct() {
        return "This is inventory service method[deduct]:" + environment.getProperty("server.port");
    }

    @GetMapping("/increase")
    public String increase() {
        return "This is inventory service method[increase]:" + environment.getProperty("server.port");
    }

}
