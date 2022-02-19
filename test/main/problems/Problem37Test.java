package main.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem37Test {

    @Test
    void solveSudoku() {
        char [][]board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new Problem37().solveSudoku(board);
    }

    @Test
    void solveSudokuFailed() {
        char [][]board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        new Problem37().solveSudoku(board);
    }

//    @Test
//    void removeOptionTest9() {
//        int[] posAnswer = new int[]{1,2,3,4,5,6,7,8,9};
//        int[] expected = new int[]{1,2,3,4,5,6,7,8};
//        int[] result = new Problem37().removeOption(posAnswer, 9);
//        assertArrayEquals(expected, new Problem37().removeOption(posAnswer, 9));
//        assertEquals(8, result.length);
//
//        result = new Problem37().removeOption(result, 8);
//        assertEquals(7, result.length);
//    }
//
//    @Test
//    void removeOptionTest8() {
//        int[] posAnswer = new int[]{1,2,3,4,5,6,7,8,9};
//        int[] expected = new int[]{1,2,3,4,5,6,7,9};
//
//        assertArrayEquals(expected, new Problem37().removeOption(posAnswer, 8));
//
//    }

    @Test
    void removeOptionTestMultiple() {
        int[] posAnswer = new int[]{1,2,3,4,5,6,9,9,9};
        int[] expected = new int[]{1,2,3,4,5,6};

//        assertArrayEquals(expected, new Problem37().removeOption(posAnswer, 9));

    }
}