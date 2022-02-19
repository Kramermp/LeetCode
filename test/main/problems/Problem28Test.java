package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem28Test {

    @Test
    void strStrSimple() {
        assertEquals(2, Problem28.strStr("hello", "ll"));
    }

    @Test
    void strStrMissing() {
        assertEquals(-1, Problem28.strStr("hello", "z"));
    }

    @Test
    void strStrEmpty() {
        assertEquals(0, Problem28.strStr("hello", ""));
    }
}