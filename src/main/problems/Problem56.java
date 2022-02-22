package main.problems;

import org.omg.CORBA.portable.Streamable;
import sun.awt.OSInfo;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem56 {
    ArrayList<int[]> results = new ArrayList<>();
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int[] curArr = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(hasOverlap(curArr, intervals[i][0], intervals[i][1])) {
                //curArr[0] = curArr[0] because sorting guarentees its <= the other start
                curArr[1] = Math.max(curArr[1], intervals[i][1]);
            } else {
                results.add(curArr);
                curArr = intervals[i];
            }
        }
        results.add(curArr); // Needed to clear last Remaining

        return results.toArray(new int[results.size()][2]);
    }

    boolean hasOverlap(int[] currArr, int otherStart, int otherEnd) {
        return currArr[0] <= otherEnd && currArr[1] >= otherStart;
    }
}
