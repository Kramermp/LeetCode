package main.assessments;

import java.util.Arrays;

public class MatrixSort {

    public int[][] diagonalSort(int[][] mat) {

        printMatrix(mat);
        for(int i = mat.length; i >= 0; i--) {
            System.out.println("Sorting");
            sortMatrixDiagonal(i,0, mat);
            printMatrix(mat);
        }

        for(int i = 1; i < mat[0].length; i++) {
            sortMatrixDiagonal(0,i, mat);
        }

        return mat;
    }

    private void printMatrix(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    private void sortMatrixDiagonal(int x, int y, int[][] mat) {
        int diagonalSize = getDiagonalSize(x, y, mat);
        int[] diagonalArray = new int[diagonalSize];
        getDiagonalArray(x, y, mat, diagonalArray);
        Arrays.sort(diagonalArray);
        insertIntoMatrix(x, y, mat, diagonalArray);
    }

    private void insertIntoMatrix(int x, int y, int[][] mat, int[] diagonalArray) {
        int counter = 0;
        while (y < mat.length && x < mat[y].length ) {
            mat[y][x] = diagonalArray[counter];
            x++;
            y++;
            counter++;
        }
    }

    public void getDiagonalArray(int x, int y, int[][] mat, int[] diagonalArray) {
        //return Math.min(mat.length - y, mat[x].length - x);
        int counter = 0;
        while (y < mat.length && x < mat[y].length ) {
            diagonalArray[counter] = mat[y][x];
            x++;
            y++;
            counter++;
        }
    }

    public int getDiagonalSize(int x, int y, int[][] mat) {
        int count = 0;
        //return Math.min(mat.length - y, mat[x].length - x);
        while (y < mat.length && x < mat[y].length ) {
            count++;
            x++;
            y++;
        }
        return count;
    }


}
