/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	/**
	 * Test trường hợp bình thường
	 */
	@Test
	@DisplayName("1 + 1 = 2")
	void normalTest() throws Exception {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	/**
	 * Cách test exception
	 */
	@Test
	@DisplayName("NumberFormatException")
	void exceptionTest() throws Exception {
		Calculator calculator = new Calculator();
		assertThrows(NumberFormatException.class, ()-> calculator.add(Integer.parseInt(""), 1));
	}

	/**
	 * Test với data-driven
	 */
	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"0,    1,   1",
			"1,    2,   3",
			"49,  51, 100",
			"1,  100, 101"
	})
	void dataDrivenNormal(int first, int second, int expectedResult) throws Exception {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
					() -> first + " + " + second + " should equal " + expectedResult);
	}

	/**
	 * Test với data-driven
	 */
	@ParameterizedTest(name = "{0} + {1} = {2}")
	@CsvSource({
			"'',        1,   NumberFormatException",
			"null,      2,   NumberFormatException",
			"'$$@$%',  51,   NumberFormatException",
	})
	void dataDrivenException(String first, int second, Exception expectedResult) throws Exception {
		Calculator calculator = new Calculator();
		assertThrows(expectedResult.getClass(), ()-> calculator.add(Integer.parseInt(first), second));
	}
}
