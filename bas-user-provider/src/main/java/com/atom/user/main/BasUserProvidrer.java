package com.atom.user.main;

import com.atom.user.mybatis.SqlInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@EnableEurekaClient
@RestController
@ComponentScan(basePackages = {"com.atom.user"})
@MapperScan("com.atom.user.mapper")
public class BasUserProvider {

    @Bean
    public Interceptor getInterceptor(){
        return new SqlInterceptor();
    }

    public static void main(String[] args) {
        SpringApplication.run(BasUserProvider.class,args);
    }

}
