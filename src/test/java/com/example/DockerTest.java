package com.example;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DockerTest {

	@Test
	void testFoo() {
		GenericContainer foo = new GenericContainer("example/foo")
				.waitingFor(Wait.forLogMessage(".*foo.*", 1));
		foo.start();
		assertEquals("foo\n", foo.getLogs());
	}

}
