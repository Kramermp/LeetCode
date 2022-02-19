package main.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem957 {

    public int[] prisonAfterNDays(int[] cells, int n) {
        ArrayList<HistoryEntry> history = new ArrayList<>();


        boolean pattenFound = false;

        int dayCount = 0;
        cells = getNextDay(cells);
        history.add(new HistoryEntry(getBoxed(cells), dayCount));

        HistoryEntry curEntry;
        while(!pattenFound && dayCount < n) {
            dayCount++;
            cells = getNextDay(cells);
            curEntry = new HistoryEntry(getBoxed(cells), dayCount);

            if(history.contains(curEntry)) {
                System.out.println("Pattern Found on day " + dayCount);
                pattenFound = true;
                cells = calcEndResult(n, history, dayCount);
            } else {
                //System.out.println(history.size());
                history.add(curEntry);
                System.out.println(dayCount + " : " + Arrays.toString(curEntry.key));
            }
        }

        return cells;
    }

    private int[] getNextDay(int[] cells) {
        int[] newState = new int[cells.length];
        for(int i = 1; i < cells.length - 1; i++) {
            newState[i] = (cells[i-1] == cells[i + 1] ? 1 : 0);
        }

        return newState;
    }
    private int[] calcEndResult(int n, ArrayList<HistoryEntry> history, int dayCount) {
        System.out.println("Calcing End Result Of of History");


        return Arrays.stream(history.get((n % history.size())).key).mapToInt(Integer::intValue).toArray();
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
