package com.waterlufei.TestHikaricp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class TestHikaricpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestHikaricpApplication.class, args);
	}
}
