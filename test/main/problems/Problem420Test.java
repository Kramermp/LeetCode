package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem420Test {

    @Test
    void strongPasswordCheckerSingleChar() {
        assertEquals(5, new Problem420().strongPasswordChecker("a"));
    }

    @Test
    void strongPasswordCheckerShortRepeat() {
        assertEquals(3, new Problem420().strongPasswordChecker("aaa"));
    }

    @Test
    void strongPasswordCheckerShortExtraRepeat() {
        assertEquals(2, new Problem420().strongPasswordChecker("aaaa"));
    }

    @Test
    void strongPasswordCheckerShortMissing() {
        assertEquals(1, new Problem420().strongPasswordChecker("aaaa1"));
    }

    @Test
    void strongPasswordCheckerLong() {
        assertEquals(6, new Problem420().strongPasswordChecker("A1cdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void strongPasswordCheckerLongNoDigit() {
        assertEquals(7, new Problem420().strongPasswordChecker("Abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void strongPasswordCheckerLongNoUpper() {
        assertEquals(7, new Problem420().strongPasswordChecker("1bcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void strongPasswordCheckerLongNoLower() {
        assertEquals(7, new Problem420().strongPasswordChecker("1BCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    void strongPasswordCheckerLongAllUpper() {
        assertEquals(8, new Problem420().strongPasswordChecker("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    void strongPasswordCheckerShort() {
        assertEquals(3, new Problem420().strongPasswordChecker("aA1"));
    }

    @Test
    void validNeighborTest() {
        assertEquals(false, Problem420.validNeighbor(1, "abaa"));
    }

    @Test
    void testCorrectLengthAllUpper() {
        assertEquals(2, new Problem420().strongPasswordChecker("ABCDEFGH"));
    }

    @Test
    void testCorrectLengthAllLower() {
        assertEquals(2, new Problem420().strongPasswordChecker("abcdefgh"));
    }

    @Test
    void testCorrectLengthAllDigit() {
        assertEquals(2, new Problem420().strongPasswordChecker("1234567"));
    }

    @Test
    void testCorrectLengthSlightShort() {
        assertEquals(2, new Problem420().strongPasswordChecker("12345"));
    }

    @Test
    void testCorrectLengthDoubleRepeat() {
        assertEquals(2, new Problem420().strongPasswordChecker("aaa111"));
    }

    @Test
    void testCorrectShortRepeat() {
        assertEquals(1, new Problem420().strongPasswordChecker("aaaB1"));
    }

    @Test
    void testContainsRepeatedChar() {
        assertEquals(true, Problem420.containsRepeatedChars("aAa111", 3));
    }

    @Test
    void testContainsRepeatedCharfalse() {
        assertEquals(false, Problem420.containsRepeatedChars("aAa1b1", 3));
    }

    @Test
    void testallRepeats() {
        assertEquals(3, new Problem420().strongPasswordChecker("1111111111"));
    }


    @Test
    void testallLongWithRepeats() {
        assertEquals(8, new Problem420().strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc"));
    }

    @Test
    void testallLongWithTailRepeats() {
        assertEquals(5, new Problem420().strongPasswordChecker("aA345678901234567890aaaaa"));
    }

    @Test
    void testallLongWithRepeats2() {
        assertEquals(8, new Problem420().strongPasswordChecker("aaaabbbbccccddeeddeeddeedd"));

    }

    @Test
    void testallLongWithRepeats3() {
        assertEquals(23, new Problem420().strongPasswordChecker("FFFFFFFFFFFFFFF11111111111111111111AAA"));

    }

    @Test
    void testallLongWithRepeats4() {
        assertEquals(4, new Problem420().strongPasswordChecker("A1234567890aaabbbbccccc"));
    }

    @Test
    void testallLongWithRepeats5() {
        assertEquals(5, new Problem420().strongPasswordChecker("aaaaAAAAAA000000123456"));
    }





}