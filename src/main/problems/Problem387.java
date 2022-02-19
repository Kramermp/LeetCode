package main.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Problem387 {


    public int firstUniqChar(String s) {
        //boolean[] uniq = new boolean[s.length()];
        int[] uniqIndexes = new int[26];
        Arrays.fill(uniqIndexes, -1);
        boolean[] dupeFound = new boolean[26];
        Arrays.fill(dupeFound, false);


        for(int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            int charValue = curChar - 97;

            if(!dupeFound[charValue]) {
                if (uniqIndexes[charValue] == -1) {
                    uniqIndexes[charValue] = i;
                } else {
                    // Dupe Found
                    uniqIndexes[charValue] = -1;
                    dupeFound[charValue] = true;
                }

            } else {
                // Do Nothing
            }
        }

        return minIndex(uniqIndexes);
    }

    public int minIndex(int[] uniqIndexes) {
        int min = -1;
        for(int i = 0; i < uniqIndexes.length; i++) {
            if(min == -1) {
                min = uniqIndexes[i];
            } else if(uniqIndexes[i] < min && uniqIndexes[i] != -1) {
                min = uniqIndexes[i];
            }
        }

        return min;
    }
}
