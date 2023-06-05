package com.lostsys.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={
	"com.lostsys.data.Controller", "com.lostsys.data.Service"})
@ComponentScan
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		}
}
