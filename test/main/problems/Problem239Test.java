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


    @Test
    void testSample() {
        int[] inputArr = {1,3,1,2,0,5};
        int maxSize = 3;
        int[] expected = {3,3,2,5};
        int[] results = new Problem239().maxSlidingWindow(inputArr, maxSize);

        assertArrayEquals(expected, results);
    }


    @Test
    void testAgeOut() {
        int[] inputArr = {7,2,4};
        int maxSize = 2;
        int[] expected = {7,4};

        assertArrayEquals(expected, new Problem239().maxSlidingWindow(inputArr, maxSize));
    }

    @Test
    void testAgeOutDemo() {
        int[] inputArr = {41,8467,6334,6500,9169,5724};
        int maxSize = 3;
        int[] expected = {7,4};

//        assertArrayEquals(expected, new Problem239().maxSlidingWindow(inputArr, maxSize));
    }
}