package br.com.institutointegra.api.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RsUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(RsUserApplication.class, args);
	}

}


