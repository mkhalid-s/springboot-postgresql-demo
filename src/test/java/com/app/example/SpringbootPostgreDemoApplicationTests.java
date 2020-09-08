package com.app.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.jdbc.*;
import org.springframework.boot.jdbc.*;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class SpringbootPostgreDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
