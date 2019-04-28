package com.hyj.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.hyj.framework.mapper")
//@EnableCaching
//@EnableEurekaClient
//@EnableDiscoveryClient

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
