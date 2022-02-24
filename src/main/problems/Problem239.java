package main.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem239 {

    int[] nums;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) {
            return nums;
        }

        this.nums = nums;
//        ArrayList<Integer> maxes = new ArrayList<>();
        int[] maxes = new int[(nums.length - k + 1)];
        int maxIndex = 1;
        WindowCache cache = new WindowCache(k);
        for(int i = 0; i < k; i++) {
            cache.addLast(i);
        }
        maxes[0] = nums[cache.peekFirst()];
        for(int i = k; i < nums.length; i++) {
            cache.addLast(i);
            maxes[maxIndex] = nums[cache.peekFirst()];
            maxIndex++;
        }

        return maxes;
    }

    class WindowCache extends ArrayDeque<Integer> {
        int maxSize = 0;

        WindowCache(int maxSize) {
            super(maxSize);
            this.maxSize = maxSize;
        }

        @Override
        public void addLast(Integer integer) {
//            What the answer actually should be
//            removeIf(i ->  nums[i] <= nums[integer] ||  i <= integer - maxSize);

            while(!isEmpty() && peekFirst() <= integer - maxSize) {
                pollFirst();
            }

            while(!isEmpty() && !(nums[peekLast()] > nums[integer]))
                pollLast();


            super.addLast(integer);
        }
    }
}
