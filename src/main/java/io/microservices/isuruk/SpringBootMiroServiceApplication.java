package io.microservices.isuruk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootMiroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMiroServiceApplication.class, args);
	}

}
