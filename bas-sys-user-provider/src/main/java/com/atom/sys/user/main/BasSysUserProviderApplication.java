package com.atom.sys.user.main;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@ComponentScan(basePackages = {"com.atom.sys.user","com.atom.bas.service"})
@MapperScan("com.atom.sys.user.mapper")
public class BasSysUserProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(BasSysUserProviderApplication.class,args);

    }

}
