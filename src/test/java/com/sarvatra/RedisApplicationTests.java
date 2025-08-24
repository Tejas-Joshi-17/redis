package com.sarvatra;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(RedisApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("Working Fine ....");
	}

}
