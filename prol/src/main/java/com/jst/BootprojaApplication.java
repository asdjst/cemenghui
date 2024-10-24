package com.jst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jst")
public class BootprojaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootprojaApplication.class, args);
    }

}
