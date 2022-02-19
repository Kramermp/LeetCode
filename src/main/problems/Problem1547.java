package main.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1547 {
    static HashMap<String, Integer> costCache = new HashMap<>();

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        System.out.println(Arrays.toString(cuts));
//        for(int i  = 0; i < cuts.length);

        return 0;
    }

//    private class Stick {
//        int start = 0;
//        int len = 0;
//        List<Integer> cutsReq = new ArrayList<>();

//        public Stick(int start, int end, List<Integer> cutsReq) {
//            this.start = 0;
//            this.len = end - start;
//
//            for(int i = 0 ; i < cutsReq.size(); i++) {
//                int curCutPos = cutsReq.get(i);
//                if(curCutPos > start && curCutPos < end) {
//                    this.cutsReq.add(curCutPos - start);
//                }
//            }
//        }
//
//
//        public int cut() {
//            if(cutsReq.size() == 0) {
//                return 0;
//            } else if(cutsReq.size() == 1) {
//                return (len - start);
//            } else {
//                return (len - start) + costCache.getOrDefault(tokenize(), calculateCutCost());
//            }
//        }
//
//
//        public Integer calculateCutCost() {
//            int min = Integer.MAX_VALUE;
//            for (int posCut:
//                    cutsReq) {
//                min = Math.min(min, new Stick(start, posCut, cutsReq).cut() + new Stick(posCut, len, cutsReq).cut());
//            }
//
//            costCache.put(this.tokenize(), min);
//            return min;
//        }
//
//        public String tokenize() {
//            return len + Arrays.toString(cutsReq.toArray());
//        }
//    }

}
