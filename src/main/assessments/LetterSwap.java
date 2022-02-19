package main.assessments;

import java.util.Arrays;

public class LetterSwap {


    public boolean buddyStrings(String s, String goal) {
        int maxFreq = 0;
        if(s.length() != goal.length()) {
            return false;
        }
        int diffCount = 0;

        int[] sourceFreqChart = new int[26];
        int[] goalFreqChart = new int[26];

        for(int i = 0; i < s.length() && i < goal.length();i++) {
            if(s.charAt(i) != goal.charAt(i)) {
                diffCount++;
                if(diffCount > 2) {
                    return false;
                }
            }
            sourceFreqChart[s.charAt(i) - 'a']++;
            goalFreqChart[goal.charAt(i) - 'a']++;
            maxFreq = Math.max(sourceFreqChart[s.charAt(i) - 'a'], maxFreq);
        }

        if(s.equals(goal) && maxFreq < 2){
            return false;
        }
        return Arrays.equals(goalFreqChart, sourceFreqChart);
    }
}
