package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1761Test {

    @Test
    void minTrioDegree() {
        int nodeCount = 6;
        int[][] edges = {{1,2},{1,3},{3,2},{4,1},{5,2},{3,6}};
        int expectedResults  = 3;

        assertEquals(expectedResults, new Problem1761().minTrioDegree(nodeCount, edges));
    }

    @Test
    void minTrioDegree2() {
        int nodeCount = 4;
        int[][] edges = {{1,2},{4,3},{3,1},{4,2},{2,3}};
        int expectedResults  = 2;

        assertEquals(expectedResults, new Problem1761().minTrioDegree(nodeCount, edges));
    }

    @Test
    void minTrioDegree3() {
        int nodeCount = 400;
        int[][] edges = {{1,2},{4,3},{3,1},{4,2},{2,3}};
        int expectedResults  = 2;

        assertEquals(expectedResults, new Problem1761().minTrioDegree(nodeCount, edges));
    }
}