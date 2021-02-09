package com.urmila.training.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.urmila.training.springcloud.filter.CustomFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZullGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullGatewayApplication.class, args);
	}
	@Bean
	public CustomFilter getcustomFilter()
	{
		return new CustomFilter();
	}
}
