package main.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
public class Problem75 {
    PriorityQueue<Integer> ints = new PriorityQueue<>();
    public void sortColors(int[] nums) {
        ints.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int i = 0;
        while(!ints.isEmpty()) {
            nums[i] = ints.poll();
            i++;
        }
    }
}
