package com.bible;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.bible")
public class BibleApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BibleApplication.class, args);
	}

}
