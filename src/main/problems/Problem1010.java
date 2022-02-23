package main.problems;

import java.util.HashMap;

public class Problem1010 {
    HashMap<Integer, Boolean> cache = new HashMap<>();
    Boolean cacheEntry;
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;


        for(int i = 0; i < time.length; i++) {
            for(int j = i + 1; j < time.length; j++) {
                if(isDivisible(i, j, time)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isDivisible(int i, int j, int[] time) {
        cacheEntry= cache.get(time[i] + time[j]);
        if(cacheEntry != null) {
            return cacheEntry;
        }
        cacheEntry = ((time[i] + time[j]) % 60 == 0);
        cache.put(time[i] +  time[j], cacheEntry);
        return cacheEntry;
    }
}
