package main.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem49Test {

    @Test
    void groupAnagrams() {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        String[][] expected = new String[][] {{"bat"},{"nat","tan"},{"ate","eat","tea"}};
//        List<List<String>> results =new Problem49().groupAnagrams(input);
//
//        assertEquals(expected.length, results.size());
//        for(String[] curArr : expected) {
//            boolean matched = false;
//            for(int i = 0; i < results.size(); i++) {
//                if(Arrays.equals(curArr, results.get(i).toArray(new String[results.get(i).size()]))) {
//                    matched = true;
//                    break;
//                }
//            }
//            assertTrue(matched);
//        }
    }
}