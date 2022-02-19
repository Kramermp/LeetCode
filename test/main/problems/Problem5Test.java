package main.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    @Test
    void longestPalindromeEx1Odd() {
        Assertions.assertEquals("bab", new Problem5().longestPalindrome("babad"));
    }

    @Test
    void longestPalindromeEx2Even() {
        Assertions.assertEquals("bb", new Problem5().longestPalindrome("cbbd"));
    }

    @Test
    void longestPalindromeEx3Even() {
        Assertions.assertEquals("abba", new Problem5().longestPalindrome("babbad"));
    }

    @Test
    void longestPalindromeEx4Single() {
        Assertions.assertEquals("a", new Problem5().longestPalindrome("a"));
    }

    @Test
    void longestPalindromeEx4Double() {
        Assertions.assertEquals("aa", new Problem5().longestPalindrome("aa"));
    }

    @Test
    void longestPalindromeTriple() {
        Assertions.assertEquals("aaa", new Problem5().longestPalindrome("aaa"));
    }

    @Test
    void longestPalindromeFailed() {
        Assertions.assertEquals("aca", new Problem5().longestPalindrome("aacabdkacaa"));
    }



}