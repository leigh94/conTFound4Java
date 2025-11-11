package com.leigh4java.contfound4java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConTFound4JavaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConTFound4JavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 这里可以编写需要执行的业务逻辑

		// 如果需要保持应用运行，可以添加一个等待机制，例如：
		Thread.currentThread().join();
	}
}
