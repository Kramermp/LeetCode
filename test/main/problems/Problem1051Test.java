package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1051Test {

    @Test
    void heightCheckerEx1() {
        int[] input = {1,1,4,2,1,3};
        int expected = 3;

        assertEquals(expected, new Problem1051().heightChecker(input));
    }

    @Test
    void heightCheckerEx2() {
        int[] input = {5,1,2,3,4};
        int expected = 5;

        assertEquals(expected, new Problem1051().heightChecker(input));
    }

    @Test
    void heightCheckerEx3() {
        int[] input = {1,2,3,4,5};
        int expected = 0;

        assertEquals(expected, new Problem1051().heightChecker(input));
    }
}