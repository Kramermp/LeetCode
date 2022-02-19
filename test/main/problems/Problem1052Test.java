package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1052Test {

    @Test
    void maxSatisfied() {
        int [] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;

        assertEquals(16, new Problem1052().maxSatisfied(customers, grumpy, minutes));
    }
}