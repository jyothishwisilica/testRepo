package com.wisilica.wiseconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class WiseconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WiseconnectApplication.class, args);
	}
}

