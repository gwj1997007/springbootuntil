package com.test.tools.springbootuntil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.test.tools.springbootuntil.dao")
public class SpringbootuntilApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootuntilApplication.class, args);
	}

}
