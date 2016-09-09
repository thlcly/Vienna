package com.vienna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author tonyhui
 * @since 16/9/7
 */
@EnableAutoConfiguration
@ComponentScan("com.vienna")
public class Application extends WebMvcConfigurerAdapter {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
