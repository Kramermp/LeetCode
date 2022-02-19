package main.problems;

public class Problem378 {

    public int kthSmallest(int[][] matrix, int k) {
        int index = matrix[0].length % k;
        int row = Math.floorDiv(matrix[0].length, k);
        return matrix[row][index];
    }
}
