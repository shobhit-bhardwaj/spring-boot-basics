package com.shobhit.k8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SBK8SBasicApplication {

	@GetMapping("/")
	public String hello() {
		System.out.println("Request Received for GET hello API.");

		return "Hello From Spring Boot Kubernetes";
	}

	public static void main(String[] args) {
		SpringApplication.run(SBK8SBasicApplication.class, args);
	}
}
