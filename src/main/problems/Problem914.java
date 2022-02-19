package main.problems;

import java.util.*;

public class Problem914 {

    HashSet<Integer> possibleDenominators = new HashSet<>();
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int card: deck) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        int otherCount = it.next().getValue();
        int curCount = 0;
        HashSet<Integer> denoms = getDenominators(otherCount);
        possibleDenominators.addAll(denoms);
        while (it.hasNext()) {
            curCount = it.next().getValue();
            denoms = getDenominators(curCount);
            mergeResults(denoms);
            if(possibleDenominators.size() == 0) {
                return false;
            }
        }

        return !(possibleDenominators.size() == 0);
    }

    HashSet<Integer> getDenominators(Integer integer) {
        HashSet<Integer> denominators = new HashSet<>();
        if(integer != 1)
            denominators.add(integer);
        for(int i = 2; i <= integer / 2; i++) {
            if (integer % i == 0) {
                denominators.add(i);
            }
        }
        return denominators;
    }

    void mergeResults(HashSet<Integer> denoms) {
        possibleDenominators.retainAll(denoms);
    }
}
