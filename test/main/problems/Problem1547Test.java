package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1547Test {

    @Test
    void minCost() {
        int length = 7;
        int[] cuts = {1,3,4,5};
        int expectedResults = 16;

        assertEquals(expectedResults, new Problem1547().minCost(length, cuts));
    }

    @Test
    void minCost2() {
        int length = 5;
        int[] cuts = {2,4,1,3};
        int expectedResults = 12;

        assertEquals(expectedResults, new Problem1547().minCost(length, cuts));
    }

    @Test
    void minCost3() {
        int length = 9;
        int[] cuts = {5,6,1,4,2};
        int expectedResults = 22;

        assertEquals(expectedResults, new Problem1547().minCost(length, cuts));
    }

    @Test
    void minCost4() {

        int length = 13;
        int[] cuts = {3,12,1,5,9,11,4,8,7,2,6,10};
        int expectedResults = 49;

        assertEquals(expectedResults, new Problem1547().minCost(length, cuts));

    }

    @Test
    void minCost5() {

        int length = 30;
        int[] cuts = { 13,25,16,20,26,5,27,8,23,14,6,15,21,24,29,1,19,9,3};
        int expectedResults = 127;

        assertEquals(expectedResults, new Problem1547().minCost(length, cuts));

    }

}