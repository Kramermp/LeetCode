package main.problems;

import java.util.*;
import java.util.stream.Collectors;

//384. Shuffle an Array
public class Problem384 {

    private class Solution {
        int[] origArr = null;
        int[] curArr = null;
        List<Integer> tempArr = null;

        public Solution(int[] nums) {
            this.origArr = nums;
            this.curArr = nums;
        }

        public int[] reset() {
            curArr = origArr;
            return curArr;
        }

        public int[] shuffle() {
            curArr = new int[origArr.length];
            tempArr = Arrays.stream(origArr).boxed().collect(Collectors.toList());
            Collections.shuffle(tempArr);
            curArr =  tempArr.stream().mapToInt(Integer::intValue).toArray();

            return curArr;
        }
    }

}
