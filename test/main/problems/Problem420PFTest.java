package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem420PFTest {

    @Test
    void strongPasswordCheckerShort() {
        assertEquals(3, new Problem420PF().strongPasswordChecker("aA1"));
    }

    @Test
    void strongPasswordCheckerSingleChar() {
        assertEquals(5, new Problem420PF().strongPasswordChecker("a"));
    }

    @Test
    void strongPasswordCheckerShortRepeat() {
        assertEquals(3, new Problem420PF().strongPasswordChecker("aaa"));
    }

    @Test
    void strongPasswordCheckerShortExtraRepeat() {
        assertEquals(2, new Problem420PF().strongPasswordChecker("aaaa"));
    }

    @Test
    void strongPasswordCheckerShortMissing() {
        assertEquals(1, new Problem420PF().strongPasswordChecker("aaaa1"));
    }

    @Test
    void strongPasswordCheckerLong() {
        assertEquals(6, new Problem420PF().strongPasswordChecker("A1cdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void strongPasswordCheckerLongNoDigit() {
        assertEquals(7, new Problem420PF().strongPasswordChecker("Abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void strongPasswordCheckerLongNoUpper() {
        assertEquals(7, new Problem420PF().strongPasswordChecker("1bcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    void strongPasswordCheckerLongNoLower() {
        assertEquals(7, new Problem420PF().strongPasswordChecker("1BCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    void strongPasswordCheckerLongAllUpper() {
        assertEquals(8, new Problem420PF().strongPasswordChecker("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }

    @Test
    void validNeighborTest() {
        assertEquals(false, Problem420.validNeighbor(1, "abaa"));
    }

    @Test
    void testCorrectLengthAllUpper() {
        assertEquals(2, new Problem420PF().strongPasswordChecker("ABCDEFGH"));
    }

    @Test
    void testCorrectLengthAllLower() {
        assertEquals(2, new Problem420PF().strongPasswordChecker("abcdefgh"));
    }

    @Test
    void testCorrectLengthAllDigit() {
        assertEquals(2, new Problem420PF().strongPasswordChecker("1234567"));
    }

    @Test
    void testCorrectLengthSlightShort() {
        assertEquals(2, new Problem420PF().strongPasswordChecker("12345"));
    }

    @Test
    void testCorrectLengthDoubleRepeat() {
        assertEquals(2, new Problem420PF().strongPasswordChecker("aaa111"));
    }

    @Test
    void testCorrectShortRepeat() {
        assertEquals(1, new Problem420PF().strongPasswordChecker("aaaB1"));
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
        assertEquals(3, new Problem420PF().strongPasswordChecker("1111111111"));
    }


    @Test
    void testallLongWithRepeats() {
        assertEquals(8, new Problem420PF().strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc"));
    }

    @Test
    void repeatScoreTEst() {
//        int repeatScore = new Problem420PF.StringEntry("ā111111111", 0).repeatScore();
//        int repeatScore2 = new Problem420PF.StringEntry("11b1111111", 0).repeatScore();
//        System.out.println(repeatScore + " " + repeatScore2);
//        assertTrue(repeatScore > repeatScore2);

    }

//    @Test(Timeout = 25)
//    void testallLongWithTailRepeats() {
//        assertEquals(5, new Problem420PF().strongPasswordChecker("aA345678901234567890aaaaa"));
//    }


    @Test
     void testallLongWithRepeats2() {
        assertEquals(8, new Problem420PF().strongPasswordChecker("aaaabbbbccccddeeddeeddeedd"));
    }

    @Test
    void testallLongWithRepeats3() {
        assertEquals(23, new Problem420PF().strongPasswordChecker("FFFFFFFFFFFFFFF11111111111111111111AAA"));

    }

    @Test
    void testallLongWithRepeats4() {
        assertEquals(4, new Problem420PF().strongPasswordChecker("A1234567890aaabbbbccccc"));
    }

    @Test
    void testallLongWithRepeats5() {
        assertEquals(5, new Problem420PF().strongPasswordChecker("aaaaAAAAAA000000123456"));
    }
}