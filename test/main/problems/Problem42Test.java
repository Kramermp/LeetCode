package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem42Test {

    @Test
    void flat() {
        int[] input = {0,0,0,0,0,0,0,0,0,0,0,0};
        int expected = 0;

        assertEquals(expected, new Problem42().trap(input));
    }

    @Test
    void trap() {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 6;

        assertEquals(expected, new Problem42().trap(input));
    }

    @Test
    void trapex2() {
        int[] input = {4,2,0,3,2,5};
        int expected = 9;

        assertEquals(expected, new Problem42().trap(input));
    }

    @Test
    void trapFailed() {
        int[] input = {4,2,3};
        int expected = 1;

        assertEquals(expected, new Problem42().trap(input));
    }

    @Test
    void trapDescending() {
        int[] input = {4,3,2};
        int expected = 0;

        assertEquals(expected, new Problem42().trap(input));
    }

    @Test
    void trapAsc() {
        int[] input = {2,3,4};
        int expected = 0;

        assertEquals(expected, new Problem42().trap(input));
    }

    @Test
    void testTrap() {
    }

    @Test
    void nextHighestTest() {
        int[] expected = new int[] {2, 3};
        assertArrayEquals(expected, Problem42.getNextHighest(0, new int[]{4,2,3},4));
    }

    @Test
    void getVolumeTest() {
        int[] heights = {4,2,3};
        int expected = 1;
        assertEquals(expected, Problem42.getVolume(0, 2, 3, heights));
    }
}