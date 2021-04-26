package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SurveyPortalMain {

	public static void main(String[] args) {

		SpringApplication.run(SurveyPortalMain.class, args);
		System.out.println("-------------------Application running at localhost 8085---------------");
	}

}
