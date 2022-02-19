package main.problems;

import java.util.HashMap;

public class Problem819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replace("!" , " ");
        paragraph = paragraph.replace("?", " ");
        paragraph = paragraph.replace("'", " ");
        paragraph = paragraph.replace(",", " ");
        paragraph = paragraph.replace(";", " ");
        paragraph = paragraph.replace(".", " ");
        paragraph = paragraph.toLowerCase();

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> bannedMap = new HashMap<>();

        String[] arr = paragraph.split("\\s+");

        for(int i = 0; i < banned.length; i++) {
            bannedMap.put(banned[i], 1);
        }

        int curMax = 0;
        int curCount = 0;
        String result = "";
        for(int i = 0; i < arr.length; i++) {
            if(bannedMap.get(arr[i]) == null) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                curCount = map.get(arr[i]);
                curMax = Math.max(curMax, curCount);
                if(curCount == curMax) {
                    result = arr[i];
                }
            }
        }

        return result;
    }
}
