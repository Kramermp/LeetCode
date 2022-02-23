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
        assertEquals("One Million", new Problem273().numberToWords(1000000));
    }

    @Test
    void numberToWords1000() {
        assertEquals("One Thousand", new Problem273().numberToWords(1000));
    }

    @Test
    void numberToWords90000() {
        assertEquals("Ninety Thousand", new Problem273().numberToWords(90000));
    }

    @Test
    void numberToWords9090900() {
        assertEquals("Nine Million Ninety Thousand Nine Hundred", new Problem273().numberToWords(9090900));
    }
    @Test
    void numberToWords1234567() {
        assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", new Problem273().numberToWords(1234567));
    }


    @Test
    void numberToWords12000() {
        assertEquals("Twelve Thousand", new Problem273().numberToWords(12000));
    }

    @Test
    void numberToWords12000000() {
        assertEquals("Twelve Million", new Problem273().numberToWords(12000000));
    }
}