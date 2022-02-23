package main.problems;

import java.util.Arrays;

public class Problem200 {
    boolean[][] visited;
    char[][] grid;
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        this.grid = grid;

        visited=new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '0') {
                    visited[i][j] = true;
                } else {
                    if(!visited[i][j]) {
                        islandCount++;
                        fillIsland(i, j);
                    }
                }
            }
        }
        return islandCount;
    }

    void fillIsland(int i, int j) {
        //Do Nothing and return if already visted
        if(visited[i][j])
            return;

        visited[i][j] = true;

        if(!(i <= 0) && grid[i - 1][j] == '1') {
            fillIsland(i - 1, j);
        }
        if(i != grid.length - 1 && grid[i + 1][j] == '1') {
            fillIsland(i + 1, j);
        }
        if(!(j <= 0) && grid[i][j-1] == '1') {

            fillIsland(i, j - 1);
        }
        if(j < grid[i].length - 1 && grid[i][j+1] == '1') {
            fillIsland(i, j + 1);
        }
    }
}
