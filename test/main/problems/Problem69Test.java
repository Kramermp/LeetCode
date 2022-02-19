package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem69Test {

    @Test
    void mySqrtEx1() {
        int input = 4;
        int expectedResult = 2;
        assertEquals(new Problem69().mySqrt(input), expectedResult);
    }

    @Test
    void mySqrtEx2() {
        int input = 8;
        int expectedResult = 2;
        assertEquals(new Problem69().mySqrt(input), expectedResult);
    }


}