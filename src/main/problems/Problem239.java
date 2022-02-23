package main.problems;

import java.util.*;

public class Problem239 {

    int[] nums;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) {
            return nums;
        }
        int[] maxes = new int[nums.length - k + 1];
        this.nums = nums;
        int maxIndex = 0;
        WindowCache cache = new WindowCache(k);
        for(int i = 0; i < k; i++) {
            cache.addLast(i);
        }
        for(int i = k; i < nums.length; i++) {
            cache.add(nums[i]);
            maxIndex++;
//            maxes[maxIndex]=cache.curMax;
        }

        return maxes;
    }

    class WindowCache extends ArrayDeque<Integer> {
        int maxSize = 0;
        PriorityQueue<Integer> maxes;
        WindowCache(int maxSize) {
            super();
            this.maxSize = maxSize;
        }

        @Override
        public void addLast(Integer integer) {
            super.addLast(integer);
            while (!isEmpty() && (nums[integer] > nums[getFirst()] || integer - maxSize > peekFirst())){
                removeFirst();
            }
        }

        private boolean ifRemoveOldest() {
            return size() > maxSize;
        }
    }
}
