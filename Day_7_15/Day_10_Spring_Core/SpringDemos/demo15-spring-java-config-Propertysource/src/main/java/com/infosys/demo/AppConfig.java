package com.infosys.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// The annotation used below is to specify the location of the properties file
@PropertySource("classpath:application.properties")
@ComponentScan("com.infosys.demo")
public class AppConfig {

}
