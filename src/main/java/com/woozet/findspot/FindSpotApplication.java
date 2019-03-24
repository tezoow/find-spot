package com.woozet.findspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy
public class FindSpotApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindSpotApplication.class, args);
	}

}
