package com.example.ieice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class IeiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IeiceApplication.class, args);
    }

}
