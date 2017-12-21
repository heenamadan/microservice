package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//Zuul –  gateway service that provides dynamic routing, monitoring, resiliency, security, and more

@SpringBootApplication
@EnableZuulProxy
public class APIGatewayServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(APIGatewayServiceApp.class, args);
	}
}
