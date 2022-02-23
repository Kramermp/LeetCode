package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem273Test {

    @Test
    void test() {
        System.out.println(new Problem273().numberToWords(1000000));
    }

    @Test
    void numberToWords1000000() {
        assertEquals("one million", new Problem273().numberToWords(1000000));
    }

    @Test
    void numberToWords1000() {
        assertEquals("one thousand", new Problem273().numberToWords(1000));
    }

    @Test
    void numberToWords90000() {
        assertEquals("ninety thousand", new Problem273().numberToWords(90000));
    }

    @Test
    void numberToWords9090900() {
        assertEquals("ninety million", new Problem273().numberToWords(90000));
    }

    @Test
    void numberToWords12000() {
        assertEquals("twelve thousand", new Problem273().numberToWords(12000));
    }

    @Test
    void numberToWords12000000() {
        assertEquals("twelve million", new Problem273().numberToWords(12000000));
    }
}