package com.arquivo.csv.arquivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ArquivoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquivoApplication.class, args);
	}

}
