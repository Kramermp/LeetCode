package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem179Test {

    @Test
    void largestNumberEx1() {
        int[] nums = {10,2};
        String result =  "210";
        assertEquals(result, new Problem179().largestNumber(nums));
    }

    @Test
    void largestNumberEx2() {
        int[] nums = {3,30,34,5,9};
        String result =  "9534330";
        assertEquals(result, new Problem179().largestNumber(nums));
    }

    @Test
    void largestNumberEx3() {
        int[] nums = {3,30,34,5,9};
        String result =  "9534330";
        assertEquals(result, new Problem179().largestNumber(nums));
    }

    @Test
    void largestNumberEx4() {
        int[] nums = {8308,8308,830};
        String result =  "83088308830";
        assertEquals(result, new Problem179().largestNumber(nums));
    }

    @Test
    void testNumEntry() {
        int[] expectedResults = {1,0,0};
        assertArrayEquals(expectedResults, new Problem179.NumEntry(100).digits);
    }

    @Test
    void testNumEntryDigitCompare() {
        Problem179.NumEntry entry1 = new Problem179.NumEntry(3);
        Problem179.NumEntry entry2 = new Problem179.NumEntry(34);

        assertEquals(-1, entry2.compareTo(entry1));
    }

    @Test
    void testNumEntryDigitCompareEqual() {
        Problem179.NumEntry entry1 = new Problem179.NumEntry(3);
        Problem179.NumEntry entry2 = new Problem179.NumEntry(3);

        assertEquals(0, entry2.compareTo(entry1));
    }

    @Test
    void testNumEntryDigitCompareLess() {
        Problem179.NumEntry entry1 = new Problem179.NumEntry(4);
        Problem179.NumEntry entry2 = new Problem179.NumEntry(3);

        assertEquals(1, entry2.compareTo(entry1));
    }

    @Test
    void testNumEntryDigitFailedEx() {
        Problem179.NumEntry entry1 = new Problem179.NumEntry(432);
        Problem179.NumEntry entry2 = new Problem179.NumEntry(43243);

        assertEquals(-1, entry2.compareTo(entry1));
    }

    @Test
    void testNumEntryDigitFailedExFull() {
        int[] nums = {432,43243};
        String result =  "43243432";
        assertEquals(result, new Problem179().largestNumber(nums));
    }

    @Test
    void testNumEntryDigitCompareFlex() {
        Problem179.NumEntry entry1 = new Problem179.NumEntry(830);
        Problem179.NumEntry entry2 = new Problem179.NumEntry(8308);

        assertEquals(entry1.compareTo(entry2), (entry2.compareTo(entry1) * -1));
    }

    @Test
    void testZeros() {
        int[] nums = {0,0};
        String result =  "0";
        assertEquals(result, new Problem179().largestNumber(nums));
    }

}