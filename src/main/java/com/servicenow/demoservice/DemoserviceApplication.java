package com.servicenow.demoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.servicenow.demoservice.clintreq.Businesslogic;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class DemoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoserviceApplication.class, args);
	}
//	@Bean
//	public RestTemplate getRest() {
//		return new RestTemplate();
//	}
	

}
