package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem914Test {

    @Test
    void hasGroupsSizeTrue() {
        int[] input = {1,2,3,4,4,3,2,1};
        boolean expected = true;

        assertEquals(expected, new Problem914().hasGroupsSizeX(input));
    }

    @Test
    void hasGroupsSizeFalse() {
        int[] input =  {1,1,1,2,2,2,3,3};
        boolean expected =  false;

        assertEquals(expected, new Problem914().hasGroupsSizeX(input));

    }

    @Test
    void hasGroupsSizeTrue2() {
        int[] input =  {1,1,2,2,2,2};
        boolean expected =  true;

        assertEquals(expected, new Problem914().hasGroupsSizeX(input));


    }

    @Test
    void hasGroupsSizeSingle() {
        int[] input =  {1};
        boolean expected =  false;

        assertEquals(expected, new Problem914().hasGroupsSizeX(input));
    }

    @Test
    void hasGroupsSizeDouble() {
        int[] input =  {1, 1};
        boolean expected =  true;

        assertEquals(expected, new Problem914().hasGroupsSizeX(input));
    }
}