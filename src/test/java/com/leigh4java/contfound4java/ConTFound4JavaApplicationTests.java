package com.leigh4java.contfound4java;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConTFound4JavaApplicationTests {

	@Test
	void contextLoads() {
		String str = "2025-12-22";
		System.out.println(str.substring(0,4));
	}

	public static void main(String[] args) {
		String str = "2025-12-22";
		System.out.println(str.substring(0,4));
	}

}
