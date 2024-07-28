package com.example.ecomerce.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest()
//@TestPropertySource(properties = "spring.liquibase.enabled=false")
@ActiveProfiles("test")
class UserApplicationTests {

	@Test
	void contextLoads() {
	}

}
