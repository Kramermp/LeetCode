package main.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem438 {

    public List<Integer> findAnagrams(String sourceString, String target) {
        List<Integer> results = new ArrayList<>();
        if(target.length() > sourceString.length()) {
            return results;
        }

        int[] targetFreqChart = buildFrequencyChart(target);
        int[] bufferFreqChart = new int[26];
        LinkedList<Character> runningBuffer = new LinkedList<>();

        for(int i = 0; i < sourceString.length(); i++) {
            addCharToBuffer(sourceString.charAt(i), runningBuffer, target.length(), bufferFreqChart);
            if(Arrays.equals(targetFreqChart, bufferFreqChart)) {
                //Subtaction to get the Start index not current index
                results.add(i - (runningBuffer.size() - 1));
            }
        }

        return results;
    }

    private int[] buildFrequencyChart(String string) {
        //System.out.println(string);
        int[] freqChart = new int[26];
        Arrays.fill(freqChart, 0);
        for(int i = 0; i < string.length(); i++) {
            freqChart[string.charAt(i) - 97]++;
        }
        //System.out.println(Arrays.toString(freqChart));

        return freqChart;
    }

    private int[] buildFrequencyChart(LinkedList<Character> stringBuffer) {
        int[] freqChart = new int[26];
        Arrays.fill(freqChart, 0);
        for(int i = 0; i < stringBuffer.size(); i++) {
            freqChart[stringBuffer.get(i) - 97]++;
        }
        //System.out.println(Arrays.toString(freqChart));
        return freqChart;
    }

    private void addCharToBuffer(char curChar, LinkedList<Character> runningBuffer, int maxSize, int[] frequencyChart) {
        runningBuffer.add(curChar);
        frequencyChart[curChar - 97]++;
        if (runningBuffer.size() > maxSize) {
            frequencyChart[runningBuffer.pop() - 97]--;
        }
    }
}
