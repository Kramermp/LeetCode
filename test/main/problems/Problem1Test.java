package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void twoSumSimple() {
        int[] input = {2,7,11,15};
        int target = 9;
        int[] expect = {0,1};

        assertArrayEquals(expect, new Problem1().twoSum(input, target));

    }

    @Test
    void twoSumSimple2() {
        int[] input = {3,2,4};
        int target = 6;
        int[] expect = {1,2};

        assertArrayEquals(expect, new Problem1().twoSum(input, target));

    }

    @Test
    void twoSumSimple3() {
        int[] input = {3,3};
        int target = 6;
        int[] expect = {0,1};

        assertArrayEquals(expect, new Problem1().twoSum(input, target));

    }
}