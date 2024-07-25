package com.example.QuanLyInAnDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"QLIA_Model"})
public class QuanLyInAnDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuanLyInAnDemoApplication.class, args);
	}

}
