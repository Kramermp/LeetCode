package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1010Test {

    @Test
    void numPairsDivisibleBy60() {
        int[] input = {30,20,150,100,40};
        int expected = 3;

        assertEquals(expected, new Problem1010().numPairsDivisibleBy60(input));
    }

    @Test
    void numPairsDivisibleBy60All() {
        int[] input = {60,60,60};
        int expected = 3;

        assertEquals(expected, new Problem1010().numPairsDivisibleBy60(input));
    }
}