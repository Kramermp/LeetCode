package main.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Problem49 {
    StringBuilder hasher = new StringBuilder();
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> results = new HashMap<>();
        Integer[] freqChart = new Integer[26];
        String curHash  = "";
        for(String curString : strs) {
            buildFreqChart(curString, freqChart);
            curHash = hash(freqChart);
            if(results.containsKey(curHash)) {
                results.get(curHash).add(curString);
            } else {
                ArrayList<String> curValu = new ArrayList<String>();
                curValu.add(curString);
                results.put(curHash, curValu);
            }
        }

        return results.values().stream().collect(Collectors.toList());
    }
    private String hash(Integer[] freqChart) {
        hasher.setLength(0);
        for(int i = 0; i < freqChart.length; i++) {
            hasher.append(freqChart[i] + "|");
        }
        return hasher.toString();
    }

    private void buildFreqChart(String string, Integer[] freqChart) {
        Arrays.fill(freqChart, 0);
        for(int i = 0; i < string.length(); i++) {
            freqChart[string.charAt(i) - 'a']++;
        }
    }
}
