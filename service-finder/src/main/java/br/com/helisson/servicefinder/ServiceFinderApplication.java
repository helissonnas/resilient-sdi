package br.com.helisson.servicefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("br.com.helisson.servicefinder")
public class ServiceFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFinderApplication.class, args);
	}

}
