package com.qiyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qiyu.boot.dao")
public class BootApplication {


	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
