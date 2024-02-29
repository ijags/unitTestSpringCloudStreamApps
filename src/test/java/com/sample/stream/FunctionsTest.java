package com.sample.stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FunctionsTest {
	
	private final Functions functions = new Functions();
	
	@Test
	void testUpperCase() {
		String input = "Test my function";
		String expectedOutput = "TEST MY FUNCTION";
		
		String actualOutput = functions.upperCase().apply(input);
		
		assertThat(expectedOutput).isEqualTo(actualOutput);
	}
	
	@Test
	void testReverse() {
		String input = "Test my function";
		String expectedOutput = "noitcnuf ym tseT";
		
		String actualOutput = functions.reverse().apply(input);
		assertThat(expectedOutput).isEqualTo(actualOutput);
	
	}
	
	@Test
	void testUppercaseThenReverse() {
		String input = "Test my function";
		String expectedOutput = "NOITCNUF YM TSET";
		
		String actualOuput = functions.upperCase().andThen(functions.reverse()).apply(input);
		assertThat(expectedOutput).isEqualTo(actualOuput);
	}

}
