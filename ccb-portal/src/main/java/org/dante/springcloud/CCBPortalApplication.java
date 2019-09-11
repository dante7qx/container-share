package org.dante.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CCBPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CCBPortalApplication.class, args);
	}
	
}
