package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1631Test {

    @Test
    void minimumEffortPathEx1() {
        int[][] input = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        int expectedResult = 2;

        assertEquals(expectedResult, new Problem1631().minimumEffortPath(input));
    }

    @Test
    void minimumEffortPathEx2() {
        int[][] input = new int[][]{{1,2,3},{3,8,4},{5,3,5}};
        int expectedResult = 1;

        assertEquals(expectedResult, new Problem1631().minimumEffortPath(input));
    }

    @Test
    void minimumEffortPathEx3() {
        int[][] input = new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        int expectedResult = 0;

        assertEquals(expectedResult, new Problem1631().minimumEffortPath(input));
    }
}