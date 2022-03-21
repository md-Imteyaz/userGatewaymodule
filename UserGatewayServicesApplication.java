package com.ZuuleGateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@ComponentScan("com.ZuuleGateway.**")
@SpringBootApplication
public class UserGatewayServicesApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(UserGatewayServicesApplication.class).registerShutdownHook(true).run(args);
	}

}
