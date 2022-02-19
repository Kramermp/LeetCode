package main.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem6 {

    boolean isZig = true;
    //Implied boolean isZag == !isZag
    int curPos = 0;
    //int curX = 0;
    int curY = 0;
    int maxY = Integer.MAX_VALUE;
    StringBuilder[] rows = null;

    public String convert(String stringToConvert, int numRows) {
        // If 1 Row Quick Exit without any processing Also if its shorter then rows
        if(numRows == 1 || stringToConvert.length() <= numRows) {
            return stringToConvert;
        }
        initializeVariables(stringToConvert, numRows);

        for(int i = 0; i < stringToConvert.length();i++) {
            (rows[curY]).append(stringToConvert.charAt(i));
            updatePosition();
            updateState();
        }

        consolidateResults();
        return rows[0].toString();
    }

    private void consolidateResults() {
        for(int i = 1; i < rows.length; i++) {
            rows[0].append(rows[i]);
        }
    }

    private void initializeVariables(String s, int numRows) {
        rows = new StringBuilder[numRows];
        for(int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        maxY = numRows - 1; // -1 to Convert to 0 Index
    }

    private void updatePosition() {
        if(isZig) {
            //X Stays Same;
            curY++;
        } else {
            //curX++; Not Needed
            curY--;
        }
    }

    private void updateState() {
        if(curY == 0) {
            isZig = true;
        } else if (curY == maxY) {
            isZig = false;
        }
    }
}
