package main.assessments;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.lang.reflect.Array;
import java.security.UnresolvedPermission;
import java.util.*;

public class WordPattern {

    PriorityQueue<String> test;


    public String reorderLogFiles(String paragraph, String[] banned) {
        paragraph = paragraph.replace("!" , "");
        paragraph = paragraph.replace("?", "");
        paragraph = paragraph.replace("'", "");
        paragraph = paragraph.replace(",", "");
        paragraph =paragraph.replace(";", "");
        paragraph =paragraph.replace(".", "");
        paragraph =paragraph.toLowerCase();

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> bannedMap = new HashMap<>();

        String[] arr = paragraph.split(" ");

        for(int i = 0; i < banned.length; i++) {
            bannedMap.put(banned[i], 1);
        }

        int curMax = 0;
        int curCount = 0;
        String result = "";
        for(int i = 0; i < arr.length; i++) {
            if(bannedMap.get(arr[i]) == null) {
                curCount = map.put(arr[i], map.getOrDefault(arr[i], 1));
                curMax = Math.max(curMax, curCount);
                if(curCount == curMax) {
                    result = arr[i];
                }
            }
        }

        return result;
    }
}
