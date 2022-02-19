package main.assessments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixSortTest {

    @Test
    void getDiagonalSize() {
        int[][] mat = new int[2][2];
        assertEquals(2, new MatrixSort().getDiagonalSize(0,0, mat));
    }

    @Test
    void getDiagonalSize2() {
        int[][] mat = new int[2][2];
        assertEquals(1, new MatrixSort().getDiagonalSize(1,0, mat));
    }

    @Test
    void getDiagonalSize3() {
        int[][] mat = new int[6][3];
        assertEquals(3, new MatrixSort().getDiagonalSize(0,0, mat));
    }

    @Test
    void testGetDiagonalArray() {
        int[][] mat = new int[6][3];
        int[] result = new int[3];
        mat[0][0] = 5;
        mat[1][1] = 1;
        int[] expected = {5,1,0};
        new MatrixSort().getDiagonalArray(0,0, mat,result);

        assertArrayEquals(expected, result);
    }

    @Test
    void testMatrixSort() {

        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] expected = {{1,1,1,1},{1,2,2,2},{1,2,3,3}};

        new MatrixSort().diagonalSort(mat);

        assertArrayEquals(expected, mat);

    }
}