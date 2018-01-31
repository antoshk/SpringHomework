package com.gmail.shelkovich.anton.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.gmail.shelkovich.anton.config",
        "com.gmail.shelkovich.anton.service", "com.gmail.shelkovich.anton.repository"})
public class RootConfig {
}
