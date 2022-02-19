package main.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
 *
 *     0 <= i, j, k, l < n
 *     nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class Problem454 {

    HashMap<Integer, Integer> freqencyMap = new HashMap<>();

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int counter = 0;
        for(int i  = 0; i < nums1.length; i++) {
            for(int j = 0; i < nums2.length; j++) {
                freqencyMap.put(nums1[i] + nums2[j], freqencyMap.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }

        for(int i  = 0; i < nums3.length; i++) {
            for(int j = 0; i < nums4.length; j++) {
                counter+= freqencyMap.getOrDefault((nums3[i] + nums4[j]) * -1,0);
            }
        }

        return counter;
    }
}
