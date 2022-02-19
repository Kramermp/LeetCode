package main.problems;

import java.util.Arrays;
import java.util.HashMap;

public class Problem525 {

    HashMap<Integer, Integer> sumMap = new HashMap<>();

    public int findMaxLength(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] == 0) ? -1 : nums[i];
        }

        int currentSum = 0;
        int prevIndex = 0;
        int maxLength = 0;
        sumMap.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            currentSum+=nums[i];
            prevIndex = sumMap.getOrDefault(currentSum, i);
            if(prevIndex != i) {
                maxLength = Math.max(maxLength, i - prevIndex);
            }
            sumMap.put(currentSum, prevIndex);
        }

        return maxLength;
    }

}
