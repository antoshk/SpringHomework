package com.gmail.shelkovich.anton.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages={"com.gmail.shelkovich.anton.bean"})
@EnableAspectJAutoProxy
public class RootConfig {
}
