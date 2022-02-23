package main.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(a -> a[1] * -1));

        int units = 0;
        int curBoxType = 0;
        int boxes = 0;
        while(truckSize > 0 && curBoxType < boxTypes.length ) {
            boxes = Math.min(boxTypes[curBoxType][0], truckSize);
            units+=(boxes * boxTypes[curBoxType][1]);
            truckSize-=boxes;
            curBoxType++;
        }

        return units;
    }
}
