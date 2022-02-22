package main.problems;

public class Problem42 {

    int runningTotal = 0;
    public int trap(int[] heights) {
        int[] results;
        int curHeight = heights[0];
        for(int i = -1; i < heights.length;) {
            results = getNextHighest(i, heights, curHeight);
            runningTotal+=getVolume(i, results[0], results[1], heights);
            i=results[0];
            curHeight = (i != heights.length ? heights[i] : -1);
        }

        return runningTotal;
    }

    public static int getVolume(int start, int end, int height, int[]heights) {
        int vol = 0;
        for(int i = start + 1; i < end; i++) {
            vol+=(height - heights[i]);
        }
        return vol;
    }

    //Results[1] --Volume Added
    //Results[0] --Next Index
    public static int[] getNextHighest(int startingIndex, int[] heights, int curHeight) {
        int highestIndex = startingIndex + 1;
        int highest = 0;
        for(int i = startingIndex + 1; i < heights.length; i++) {
            if(heights[i] > highest) {
                highestIndex = i;
                highest= heights[i];
                if(highest >= curHeight) {
                    highest = Math.min(curHeight, highest);
                    break;
                }
            }
        }

        return new int[]{highestIndex, highest};
    }
}
