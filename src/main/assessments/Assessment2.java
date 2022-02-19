package main.assessments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Assessment2 {

    //Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
    public int[] sortedSquares(int[] nums) {
        return new int[0];
    }

    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();

        String workingCopy = s;
        String curString = s;

        for(int i = 0; i < order.length(); i++) {
            char curChar = order.charAt(i);
            for(int j = 0; j < curString.length(); j++) {

                if(curString.charAt(j) == curChar) {
                    sb.append(curChar);
                    workingCopy = workingCopy.replaceFirst(String.valueOf(curChar), "");
                } else if (!order.contains(String.valueOf(curString.charAt(j)))) {
                    sb.append(s.charAt(j));
                    workingCopy = workingCopy.replaceFirst(String.valueOf(s.charAt(j)), "");
                }
            }

            curString = workingCopy;
        }

        return sb.toString();
    }
}
