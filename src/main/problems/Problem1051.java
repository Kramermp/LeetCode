package main.problems;

import java.util.Arrays;

public class Problem1051 {

    public int heightChecker(int[] heights) {
        int counter  = 0;
        int[] expected = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(expected);

        for(int i  = 0; i < expected.length; i++) {
            if(expected[i] != heights[i])
                counter++;
        }

        return counter;
    }
}
