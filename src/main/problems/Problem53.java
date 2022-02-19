package main.problems;

public class Problem53 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curSum = 0;

        for(int i = 0; i < nums.length; i++) {
            curSum+=nums[i];
            if(max < curSum){
                max = curSum;
            }

            if (curSum < 0) {
                curSum = 0;
            }
        }

        return max;
    }
}
