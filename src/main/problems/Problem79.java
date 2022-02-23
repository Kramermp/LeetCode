package main.problems;

import java.util.stream.IntStream;

public class Problem79 {

    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        int curSearchIndex = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    find(i,j,1, word);
                }
            }
        }

        return false;
    }

    private boolean find(int i, int j, int index, String word) {
        if(index == word.length()) {
            return true;
        }

        visited[i][j] = true;
        if(!(i <= 0)) {
//            find(i - 1);
        }

        return false;
    }

}
