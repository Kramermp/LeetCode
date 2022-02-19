package main.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1157 {
    int[] arr;
    int[] subArr;
    int[] downArr;
    int[] upArr;

    HashMap<Integer, Integer> counter;
    Random rng = new Random();
    int maxChecks = 0;
    int indexToCheck = 0;
    int currentValue = 0;

    public Problem1157(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {

        subArr = Arrays.copyOfRange(arr, left, right + 1);
        Arrays.sort(subArr);

        int resultCounter = 0;

        int midIndex = calculateMid(subArr.length);
        int midValue = subArr[midIndex];
        int downIndex = midIndex - 1;
        int upIndex = midIndex;
        boolean upSearchComplete = !(upIndex < subArr.length);
        boolean downSearchComplete = !(downIndex >= 0);

        while (!upSearchComplete) {
            if (upIndex < subArr.length && subArr[upIndex] == midValue) {
                resultCounter++;
                upIndex++;
            } else {
                upSearchComplete = true;
            }
        }
        while(!downSearchComplete) {
            if (downIndex >= 0 && subArr[downIndex] == midValue) {
                resultCounter++;
                downIndex--;
            } else {
                downSearchComplete = true;
            }
        }

        return (resultCounter >= threshold) ? midValue : -1;
    }



//        for(int i = 0; i < maxChecks; i++) {
//            indexToCheck = rng.nextInt(subArr.size());
//            currentValue = subArr.get(indexToCheck);
//
//            if (counter.get(currentValue) == null) {
//                counter.put(currentValue, 1);
//            } else {
//                counter.put(currentValue, counter.get(currentValue) + 1);
//            }
//            if(counter.get(currentValue) >= threshold) {
//                return subArr.get(indexToCheck);
//            }
//
//            subArr.remove(indexToCheck);
//        }
  //  }

    public static int calculateMid (int length) {
        return (int) Math.floor((length / 2d));
    }


}
