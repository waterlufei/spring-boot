package com.waterlufei.TestOauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class TestOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(TestOauth2Application.class, args);
	}
}
