package com.lostsys.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
	"com.lostsys.data.Controller", "com.lostsys.data.Service"})
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		}
		// Esto es un comentario 
}
