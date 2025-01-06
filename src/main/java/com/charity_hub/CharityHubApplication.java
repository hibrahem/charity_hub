package com.charity_hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = CharityHubApplication.class)
public class CharityHubApplication {

    public static void main(String[] args) {
        ApplicationModules.of(CharityHubApplication.class).verify();
        SpringApplication.run(CharityHubApplication.class, args);
    }
}