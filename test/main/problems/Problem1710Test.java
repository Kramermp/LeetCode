package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1710Test {

    @Test
    void maximumUnits() {
        int[][] inputArr =  {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        int expected = 8;

        assertEquals(expected, new Problem1710().maximumUnits(inputArr, truckSize));
    }
}