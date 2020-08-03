package bt.com.sdi.resilient.sdigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class SdiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdiGatewayApplication.class, args);
	}

}
