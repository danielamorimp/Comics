package br.com.daniel.comics;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableScheduling
@SpringBootApplication
public class ComicsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ComicsApplication.class, args);

	}

}
