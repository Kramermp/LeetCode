package main.problems;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem1346 {
    HashMap<Integer, Integer> seen = new HashMap<>();
    HashMap<Integer, Integer> doubles = new HashMap<>();

    public boolean checkIfExist(int[] arr) {

        for(int i = 0; i < arr.length; i++) {
            if(doubles.get(arr[i]) != null)
                return true;

            doubles.put(arr[i] * 2, i);
            seen.put(arr[i], i);
        }

        return false;
    }
}
