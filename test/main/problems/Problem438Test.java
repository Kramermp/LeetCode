package main.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem438Test {

    @Test
    void findAnagrams() {
        List<Integer> results = new Problem438().findAnagrams("cbaebabacd", "abc");
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(6);

        assertEquals(expected, results);
    }
}