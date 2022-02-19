package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1103Test {

    @Test
    void testDistributeCandiesEx1() {
        int candies = 7;
        int numPeople = 4;
        int[] expectedResults = new int[]{ 1, 2, 3, 1};

        assertArrayEquals(new Problem1103().distributeCandies(candies, numPeople), expectedResults);
    }

    @Test
    void testDistributeCandiesEx2() {
        int candies = 10;
        int numPeople = 3;
        int[] expectedResults = new int[]{ 5, 2, 3};

        assertArrayEquals(new Problem1103().distributeCandies(candies, numPeople), expectedResults);
    }
}