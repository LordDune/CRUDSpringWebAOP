package com.example.demo.config;

import com.example.demo.aspects.LoggingAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "com.example.demo")
public class Configuration {
    @Bean
    public LoggingAspects aspects() {
        return new LoggingAspects();
    }
}