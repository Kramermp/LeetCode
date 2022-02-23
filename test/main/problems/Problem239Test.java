package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem239Test {

    @Test
    void test() {
        int[] inputArr = {1,3,-1,-3,5,3,6,7};
        int maxSize = 3;
        int[] expected = {3,3,5,5,6,7};

        assertArrayEquals(expected, new Problem239().maxSlidingWindow(inputArr, maxSize));
    }
}