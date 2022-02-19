package main.problems;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.stream;

//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
public class Problem136 {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> results = new ArrayList<>();
        for(Integer curInt : nums) {
            if(results.contains(curInt)) {
                results.remove(curInt);
            } else {
                results.add(curInt);
            }
        }

        return results.get(0);
    }
}
