package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem179ComparatorTest {

    @Test
    void largestNumberEx1() {
        int[] nums = {10,2};
        String result =  "210";
        assertEquals(result, new Problem179Comparator().largestNumber(nums));
    }

    @Test
    void largestNumberEx2() {
        int[] nums = {3,30,34,5,9};
        String result =  "9534330";
        assertEquals(result, new Problem179Comparator().largestNumber(nums));
    }

    @Test
    void largestNumberEx3() {
        int[] nums = {3,30,34,5,9};
        String result =  "9534330";
        assertEquals(result, new Problem179Comparator().largestNumber(nums));
    }

    @Test
    void largestNumberEx4() {
        int[] nums = {8308,8308,830};
        String result =  "83088308830";
        assertEquals(result, new Problem179Comparator().largestNumber(nums));
    }

    @Test
    void testNumEntry() {
        int[] expectedResults = {1,0,0};
        assertArrayEquals(expectedResults, new Problem179.NumEntry(100).digits);
    }


    @Test
    void testNumEntryDigitFailedExFull() {
        int[] nums = {432,43243};
        String result =  "43243432";
        assertEquals(result, new Problem179Comparator().largestNumber(nums));
    }

    @Test
    void testNumEntryDigitSingle() {
        int[] nums = {1};
        String result =  "1";
        assertEquals(result, new Problem179Comparator().largestNumber(nums));
    }

    @Test
    void testZeros() {
        int[] nums = {0,0};
        String result =  "0";
        assertEquals(result, new Problem179Comparator().largestNumber(nums));
    }

}