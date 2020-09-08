package com.app.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class SpringbootPostgreDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
