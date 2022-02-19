package main.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void containsLowerCaseTrue() {
        assertEquals(true, StringUtils.containsLowerCase("a"));
    }

    @Test
    void containsLowerCaseFalse() {
        assertEquals(false, StringUtils.containsLowerCase("A"));
    }

    @Test
    void containsUpperCaseFalse() {
        assertEquals(false, StringUtils.containsUpperCase("a"));
    }

    @Test
    void containsUpperCaseTrue() {
        assertEquals(true, StringUtils.containsUpperCase("A"));
    }

    @Test
    void containsDigitFalse() {
        assertEquals(false, StringUtils.containsDigit("A"));
    }

    @Test
    void containsDigitTrue() {
        assertEquals(true, StringUtils.containsDigit("1"));
    }

    @Test
    void containsRepeatedCharsTrue() {
        assertEquals(true, StringUtils.containsRepeatedChars("aaa", 3));
    }

    @Test
    void containsRepeatedCharsTooShort() {
        assertEquals(false, StringUtils.containsRepeatedChars("aaa", 4));
    }

    @Test
    void getRepeatedIndexSimpleStart() {
        assertEquals(0, StringUtils.getRepeatedIndex("aaa", 3));
    }
    @Test
    void getRepeatedIndexSimple() {
        assertEquals(1, StringUtils.getRepeatedIndex("baaaa", 3));
    }

    @Test
    void getRepeatedIndexTooShort() {
        assertEquals(-1, StringUtils.getRepeatedIndex("aaa", 4));
    }

    @Test
    void getRepeatedIndexNo() {
        assertEquals(-1, StringUtils.getRepeatedIndex("abc", 4));
    }

    @Test
    void getRepeatedIndexNoDigit() {
        assertEquals(0, StringUtils.getRepeatedIndex("111", 3));
    }
}