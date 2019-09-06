package com.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class DockerTest {

	@Test
	@Disabled("Sometimes fails")
	void testFoo() {
		GenericContainer foo = new GenericContainer("example/foo")
				.waitingFor(Wait.forLogMessage(".*foo.*", 1));
		foo.start();
		assertEquals("foo\n", foo.getLogs());
	}

	@Test
	void testBar() {
		GenericContainer foo = new GenericContainer("example/bar")
				.waitingFor(Wait.forLogMessage(".*bar.*", 1));
		foo.start();
		assertEquals("bar\n", foo.getLogs());
	}

}
