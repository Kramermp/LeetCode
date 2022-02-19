package main.assessments;


import java.util.*;

public class Assessment1 {


    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     */
    public int[] twoSum(int[] nums, int target) {
        int[] answer = null;

        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i == j) {

                } else {
                    if (nums[i] + nums[j] == target) {
                        return new int[] {i, j};
                    }
                }
            }
        }
        return answer;
    }

    /**
     There are 8 prison cells in a row and each cell is either occupied or vacant.

     Each day, whether the cell is occupied or vacant changes according to the following rules:

     If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
     Otherwise, it becomes vacant.

     Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.

     You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0 if the ith cell is vacant, and you are given an integer n.

     Return the state of the prison after n days (i.e., n such changes described above).\

     Days are zero index for some reason
     * @param cells
     * @param n
     * @return
     */
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[] oldCells = cells.clone();
        int dayCount = 0;

        oldCells = Arrays.copyOf(cells, cells.length);

        cells[0] = 0;
        cells[cells.length - 1] = 0;
        for(int j = 1; j < cells.length - 1; j++) {
            cells[j] = (oldCells[j - 1] == oldCells[j + 1]) ? 1 : 0;
        }
        dayCount++;

        int previousValue = 0;
        int currentValue = 0;
        int j = 0;
        for(dayCount = 2; dayCount <= n; dayCount++) {
            previousValue = cells[0];
            for(j = 1; j < cells.length - 1; j++) {
                currentValue = cells[j];
                cells[j] = (previousValue == cells[j + 1]) ? 1 : 0;
                previousValue = currentValue;
            }
        }
        return cells;
    }

    public int[] prisonAfterNDaysT2(int[] cells, int n) {
        ArrayList<HistoryEntry> history = new ArrayList<>();


        boolean pattenFound = false;
        int dayCount = 0; //Day Counter
        int previousCellPastValue = 0; // Used to store the Previous Value of cell after we change it
        int currentCellValue = 0;
        //history.add(new HistoryEntry(getBoxed(cells), dayCount));

        //Day 1 Special Processing
        previousCellPastValue = cells[0];
        cells[0] = 0;
        for(int i = 1; i < cells.length - 1; i++) {
            currentCellValue = cells[i];
            cells[i] = (previousCellPastValue == cells[i + 1] ? 1 : 0);
            previousCellPastValue = currentCellValue;
        }
        cells[cells.length - 1] = 0;
        dayCount++;
        history.add(new HistoryEntry(getBoxed(cells), dayCount));
        //End Special Processing for Day 1

        System.out.println(Arrays.toString(cells));
        HistoryEntry curEntry;
        while(!pattenFound && dayCount < n) {
            dayCount++;

            previousCellPastValue = 0; //Cell[0] is always 0;
            for(int i = 1; i < cells.length - 1; i++) {
                currentCellValue = cells[i];
                cells[i] = (previousCellPastValue == cells[i + 1] ? 1 : 0);
                previousCellPastValue = currentCellValue;
            }


            curEntry = new HistoryEntry(getBoxed(cells), dayCount);

            if(history.contains(curEntry)) {
                System.out.println("Pattern Found on day " + dayCount);
                pattenFound = true;
                cells = calcEndResult(n, history, dayCount);
            } else {
                System.out.println(history.size());
                history.add(curEntry);
            }
        }

        return cells;
    }

    private int[] calcEndResult(int n, ArrayList<HistoryEntry> history, int dayCount) {
        System.out.println("Calcing End Result Of of History");
        //Repeat is detected at Day Count meaning dayCount == 0 index (1st Day)
        int length = history.size();

        System.out.println("Targeting " + n + " day.");
        System.out.println("Looped after " + length);

        int loopCounter = (int) Math.floor(n / length);
        System.out.println("Completes " + loopCounter + " loops");

        int realAdvance = (n - (loopCounter * length)) - 1;
        System.out.println("Real Advance " + realAdvance);


        return Arrays.stream(history.get(realAdvance).key).mapToInt(Integer::intValue).toArray();
    }

    private String getToken(int[] cells) {
        return Arrays.toString(cells);
    }

    Integer[] getBoxed(int[] cells) {
        return Arrays.stream(cells).boxed().toArray(Integer[]::new);
    }

    private class HistoryEntry {
        Integer[] key = null;
        Integer value = 0;

        HistoryEntry (Integer[] key, Integer day) {
            this.key = key;
            this.value = day;
        }

        @Override
        public boolean equals(Object o){
            if(!(o instanceof HistoryEntry)) {
                return false;
            } else {
                return Arrays.equals(((HistoryEntry) o).key, key);
            }
        }


    }
}
