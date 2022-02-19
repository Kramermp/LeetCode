package main.problems;

import java.util.Arrays;

public class Problem189 {


    public void rotate(int[] nums, int k) {
        int[] falloffNums;
        int realShift = k % nums.length;

        falloffNums = Arrays.copyOfRange(nums, nums.length - realShift, nums.length);
        for(int i = nums.length - 1; i >= 0; i--) {

            if(i < realShift) {
                nums[i] = falloffNums[i];
            } else {
                nums[i] = nums[i - realShift];
            }
        }

    }
}
