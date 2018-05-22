package com.bugsystem.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages="com.bugsystem.serviceimpl")
@ImportResource("classpath:spring-service.xml")
public class ServiceConfig {

}