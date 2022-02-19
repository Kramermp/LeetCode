package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem12Test {

    @Test
    void intToRoman() {
        assertEquals("III", new Problem12().intToRoman(3));
    }

    @Test
    void intTo1() {
        assertEquals("I", new Problem12().intToRoman(1));
    }

    @Test
    void intTo9() {
        assertEquals("IX", new Problem12().intToRoman(9));
    }

    @Test
    void intTo5() {
        assertEquals("V", new Problem12().intToRoman(5));
    }

    @Test
    void intTo10() {
        assertEquals("X", new Problem12().intToRoman(10));
    }

    @Test
    void intTo50() {
        assertEquals("L", new Problem12().intToRoman(50));
    }

    @Test
    void intTo100() {
        assertEquals("C", new Problem12().intToRoman(100));
    }

    @Test
    void intTo500() {
        assertEquals("D", new Problem12().intToRoman(500));
    }

    @Test
    void intTo1000() {
        assertEquals("M", new Problem12().intToRoman(1000));
    }

    @Test
    void intTo1994() {
        assertEquals("MCMXCIV", new Problem12().intToRoman(1994));
    }




}