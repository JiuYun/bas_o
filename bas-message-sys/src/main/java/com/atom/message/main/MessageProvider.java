package com.atom.message.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@ComponentScan(basePackages = {"com.atom.message"})
@MapperScan("com.atom.user.mapper")
public class MessageProvider {


    public static void main(String[] args) {
        SpringApplication.run(MessageProvider.class,args);
    }



}
