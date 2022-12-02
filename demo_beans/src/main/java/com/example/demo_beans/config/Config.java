package com.example.demo_beans.config;

import com.example.demo_beans.service.Logger;
import com.example.demo_beans.service.impl.ConsoleLogger;
import com.example.demo_beans.service.impl.FileLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;

@Configuration
public class Config {
    @Bean
    public Logger getFileLogger(){
        return new FileLogger(file());
    }
    @Bean (name = "console")
    public Logger getConsoleLogger(){
        return new ConsoleLogger();
    }

    @Bean
    File file (){
        System.out.println("file");
        return  new File("");
    }
}
