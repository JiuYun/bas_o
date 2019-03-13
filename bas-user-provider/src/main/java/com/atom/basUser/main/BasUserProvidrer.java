package com.atom.basUser.main;

import com.atom.basUser.mybatis.SqlInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@EnableEurekaClient
@RestController
@ComponentScan(basePackages = {"com.atom.basUser"})
@MapperScan("com.atom.basUser.mapper")
public class BasUserProvidrer {

    @Bean
    public Interceptor getInterceptor(){
        return new SqlInterceptor();
    }

    @RequestMapping("/userInfos")
    public Map<String,Object> userInfos(){
        return new HashMap<String, Object>(){{
            put("id","1231231231");
            put("name","123123");
        }};
    }

    public static void main(String[] args) {
        SpringApplication.run(BasUserProvidrer.class,args);
    }

}
