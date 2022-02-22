package main.problems;

import java.util.*;

public class Problem146 {
    class LRUCache {
        HashMap<Integer, Integer> cache = new HashMap<>();
        LinkedList<Integer> ageArr = new LinkedList<>();
        int capacity;
        Integer curEntry;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            curEntry = cache.get(key);
            if(curEntry == null)
                    return -1;
            //If it Contains the Key
            ageArr.remove(Integer.valueOf(key));
            ageArr.add(key);
            //System.out.println(Arrays.toString(ageArr.toArray(new Integer[ageArr.size()])));
            return curEntry;
        }

        public void put(int key, int value) {
            curEntry = cache.get(key);
            if(curEntry != null) {
                ageArr.remove(Integer.valueOf(key));
            } else {
                //System.out.println("Size: " + ageArr.size());
                //System.out.println("Cap: " + capacity);
                if(ageArr.size() >= capacity) {
                    cache.remove(ageArr.poll());
                }
                //System.out.println(ageArr.size());
            }
            ageArr.add(key);
            cache.put(key, value);
            //System.out.println(Arrays.toString(ageArr.toArray(new Integer[ageArr.size()])));
        }
    }

}
