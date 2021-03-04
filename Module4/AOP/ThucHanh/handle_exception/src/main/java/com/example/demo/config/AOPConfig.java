package com.example.demo.config;


import com.example.demo.concern.Logger;
import com.example.demo.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOPConfig {
    @Bean
    public Logger logger(){
        return new Logger();
    }
}
