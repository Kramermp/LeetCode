package main.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem56Test {

    @Test
    void testMerge() {
        int[][] input = {{1,3},{2,6},{8,10},{15,18}};
        int[][] expected = {{1,6},{8,10},{15,18}};
        int[][] results = new Problem56().merge(input);

        assertEquals(expected.length, results.length);
        for(int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], results[i]);
        }
    }

    @Test
    void testMergeSingleResult() {
        int[][] input = {{4,5},{1,4}};
        int[][] expected = {{1,5}};
        int[][] results = new Problem56().merge(input);

        assertEquals(expected.length, results.length);
        for(int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], results[i]);
        }
    }

    @Test
    void testMergeSingleGrowing() {
        int[][] input = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] expected = {{1,10}};
        int[][] results = new Problem56().merge(input);
        for(int i  = 0; i < results.length; i++) {
            System.out.println(Arrays.toString(results[i]));
        }

        assertEquals(expected.length, results.length);
        for(int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], results[i]);
        }
    }




}