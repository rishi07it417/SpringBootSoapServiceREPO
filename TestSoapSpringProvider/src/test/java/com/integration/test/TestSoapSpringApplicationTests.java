package com.integration.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestSoapSpringApplicationTests {

	@Test
	void test() {
		boolean a = true;
	  assertThat(a).isTrue();
	}

}
