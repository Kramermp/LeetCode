package main.assessments;

import main.common.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        int[] previousRow = new int[0];
        int[] newRow;
        for(int i = 0; i < numRows; i++) {
            newRow = getNextRow(previousRow);
            rows.add(getArrayList(newRow));
            previousRow = newRow;
        }

        return rows;
    }

    private ArrayList<Integer> getArrayList(int[] ints) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < ints.length; i++) {
            list.add(ints[i]);
        }
        return list;
    }

    private int[] getNextRow(int[] ints) {
        int[] nextRow = new int[ints.length + 1];
        nextRow[0] = 1;
        nextRow[nextRow.length - 1] = 1;
        for(int i = 1; i < ints.length; i++) {
            nextRow[i] = ints[i - 1] + ints[i];
        }
        return nextRow;
    }
}
