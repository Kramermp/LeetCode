package main.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem17 {
    HashMap<Character, char[]> characterHashMap = new HashMap<>();

    Problem17() {
        characterHashMap.put('2', new char[]{'a', 'b', 'c'});
        characterHashMap.put('3', new char[]{'d', 'e', 'f'});
        characterHashMap.put('4', new char[]{'g', 'h', 'i'});
        characterHashMap.put('5', new char[]{'j', 'k', 'l'});
        characterHashMap.put('6', new char[]{'m', 'n', 'o'});
        characterHashMap.put('7', new char[]{'p', 'q', 'r', 's'});
        characterHashMap.put('8', new char[]{'t', 'u', 'v'});
        characterHashMap.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> prevList = new ArrayList<>();
        ArrayList<String> newList = new ArrayList<>();
        if(digits.length() == 0) {
            return newList;
        } else {
            newList.add(""); //Need an initial String for append
            StringBuilder sb = new StringBuilder();

            char[] possibleChars = null;
            for(int i = 0 ; i < digits.length(); i++) {
                prevList = newList;
                newList = new ArrayList<>();
                for (String curString: prevList) {
                    sb = new StringBuilder(curString);
                    possibleChars = characterHashMap.get(digits.charAt(i));
                    sb.append(possibleChars[0]);
                    newList.add(sb.toString());
                    for (int j = 1; j < possibleChars.length; j++) {

                        sb.replace(i, i+1, String.valueOf(possibleChars[j]));
                        newList.add(sb.toString());
                    }
                }
            }
            return newList;
        }
    }
}
