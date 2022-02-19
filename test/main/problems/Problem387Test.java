package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem387Test {

    @Test
    void firstUniqCharEx1 () {
        assertEquals(0, new Problem387().firstUniqChar("leetcode"));
    }
    @Test
    void firstUniqCharEx2 () {
        assertEquals(2, new Problem387().firstUniqChar("loveleetcode"));
    }

    @Test
    void firstUniqCharEx3 () {
        assertEquals(-1, new Problem387().firstUniqChar("aabb"));
    }
}