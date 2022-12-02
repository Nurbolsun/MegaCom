package com.example.demo_beans;

import com.example.demo_beans.config.Config;
import com.example.demo_beans.config.ScanBean;
import com.example.demo_beans.service.Logger;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoBeansApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBeansApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBean.class);

        Logger fileLogger = (Logger) context.getBean("getFileLogger");
        Logger consolLog = (Logger) context.getBean("console");

        fileLogger.writeLog();
        consolLog.writeLog();
    }

}
