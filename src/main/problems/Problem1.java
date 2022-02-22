package main.problems;

import java.util.HashMap;

public class Problem1 {
    HashMap<Integer, Integer> differences = new HashMap<>();
    int target = 0;
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        this.target = target;
        for(int i = 0; i < nums.length; i++) {
            if(differences.containsKey(nums[i])) {
                results[0] = differences.get(nums[i]);
                results[1] = i;
                return results;
            } else {
                differences.put(target - nums[i], i);
            }
        }
        return results;
    }
}
