package com.example.demo.config;

import com.example.demo.aop.WriteFile;
import com.example.demo.controllers.BooksController;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOPConfig {
    @Bean
    public WriteFile writeFile(){
        return new WriteFile();
    }
}
