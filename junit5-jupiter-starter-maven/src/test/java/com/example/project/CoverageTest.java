package com.example.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoverageTest {
    @Test
    @DisplayName("Path 1")
    void path1() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(2147483647, calculator.add(2147483647, 1), "2147483647 + 1 should equal 2147483647");
    }

    @Test
    @DisplayName("Path 2")
    void path2() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(-2147483648, calculator.add(-2147483648, -22), "-2147483648 + (-1) should equal -2147483648");
    }

    @Test
    @DisplayName("Path 3")
    void path3() throws Exception {
        Calculator calculator = new Calculator();
        assertEquals(7, calculator.add(2, 5), "2 + 5 should equal 7");
    }
}
