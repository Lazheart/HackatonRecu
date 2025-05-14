package com.example.demo.config;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class Log4jConfig {

    @Bean
    public String initializeLog4j() {
        Properties props = new Properties();
        props.setProperty("log4j.rootLogger", "INFO, stdout");
        props.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
        props.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
        props.setProperty("log4j.appender.stdout.layout.ConversionPattern",
                "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");

        PropertyConfigurator.configure(props);
        return "Log4j initialized";
    }
}
