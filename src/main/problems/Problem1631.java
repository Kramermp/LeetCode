package main.problems;

import java.util.PriorityQueue;

public class Problem1631 {
    PriorityQueue<Cell> cellsToCheck = new PriorityQueue<>();

    Cell[][] cells;
    int endX;
    int endY;

    public int minimumEffortPath(int[][] heights) {
        cells = new Cell[heights.length][heights[0].length];
        endX = heights[0].length;
        endY = heights.length;

        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                cells[i][j] = new Cell(heights[i][j], j, i);
            }
        }

        return cells[0][0].getMinEffort();
    }

    private class Cell implements Comparable{
        int height = Integer.MAX_VALUE;
        boolean discovered = false;
        int cost;
        int x;
        int y;
        int priority = (int)Math.sqrt(Math.pow(endX - x, 2) + Math.pow(endY - y, 2));

        private Cell(int height, int x, int y) {
            this.height = height;
            this.x = x;
            this.y = y;
        }

        private int getMin(int[] intArray) {
            int min = intArray[0];
            for(int i = 1; i < intArray.length; i++) {
                if(intArray[i] < min ) {
                    min = intArray[i];
                }
            }
            return min;
        }

        private int getMinEffort() {
            this.discovered = true;
            if(x == endX && y == endY) {
                return 0;
            }

            int[] neighborScores = new int[4];

            //Check Left
            if(x != 0 && !cells[y][x - 1].discovered) {
                cellsToCheck.add(cells[y][x-1]);
            } else {
                neighborScores[0] = Integer.MAX_VALUE;
            }

            //Check Right
            if(x != 0 && !cells[y][x + 1].discovered) {
                cellsToCheck.add(cells[y][x+1]);
            } else {
                neighborScores[1] = Integer.MAX_VALUE;
            }


            return getMin(neighborScores);
        }

        @Override
        public int compareTo(Object otherCell) {
            if (otherCell instanceof Cell) {
                Integer prio = new Integer(priority);
                return prio.compareTo(((Cell) otherCell).priority);
            } else {
                return -1;
            }
        }
    }

}
