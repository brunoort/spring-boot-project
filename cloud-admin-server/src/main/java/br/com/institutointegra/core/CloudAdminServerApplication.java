package br.com.institutointegra.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
@EnableEurekaClient
public class CloudAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudAdminServerApplication.class, args);
	}

}
