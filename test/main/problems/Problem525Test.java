package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem525Test {

    @Test
    void findMaxLengthNone() {
        int[] nums = {0, 0};
        assertEquals(0, new Problem525().findMaxLength(nums));
    }

    @Test
    void findMaxLength() {
        int[] nums = {0, 1};
        assertEquals(2, new Problem525().findMaxLength(nums));
    }

    @Test
    void findMaxLengthLonger() {
        int[] nums = {0, 0,0,1,1, 1};
        assertEquals(6, new Problem525().findMaxLength(nums));
    }

    @Test
    void findMaxLengthLongerInverse() {
        int[] nums = {1, 1, 1, 0, 0, 0};
        assertEquals(6, new Problem525().findMaxLength(nums));
    }

    @Test
    void findMaxLengthLongerNonZeroFinish() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1};
        assertEquals(6, new Problem525().findMaxLength(nums));
    }

    @Test
    void findMaxLengthLongerNonZeroFinish2() {
        int[] nums = {1, 1, 0, 0, 0, 0, 0};
        assertEquals(4, new Problem525().findMaxLength(nums));
    }
}