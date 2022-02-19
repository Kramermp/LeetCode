package main.assessments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class assessment1Test {

    @Test
    void testSimple() {
        int[] nums = {2,7,11,15};
        int target = 9;
        new Assessment1().twoSum(nums, target);
    }

    @Test
    void testSimple2() {
        int[] cells = {0,1,0,1,1,0,0,1};
        int n = 7;
        int[] results = {0,0,1,1,0,0,0,0};

        Assertions.assertArrayEquals(results, new Assessment1().prisonAfterNDaysT2(cells, n));
    }

    @Test
    void testSimpleBulk() {
        int[] cells = {1,0,0,1,0,0,1,0};
        int n = 1000000000;
        int[] results = {0,0,1,1,1,1,1,0};

        Assertions.assertArrayEquals(results, new Assessment1().prisonAfterNDaysT2(cells, n));
    }

    @Test
    void testSimpleFailed() {
        int[] cells = {0,0,1,1,1,1,0,0};
        int n = 8;
        int[] results = {0,0,0,1,1,0,0,0};

        Assertions.assertArrayEquals(results, new Assessment1().prisonAfterNDaysT2(cells, n));
    }





}