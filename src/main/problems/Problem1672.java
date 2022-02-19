package main.problems;

public class Problem1672 {

    public int maximumWealth(int[][] accounts) {

        int maxSum = sumArray(accounts[0]);
        int curSum = 0;

        for(int i = 1; i < accounts.length; i++) {
            curSum = sumArray(accounts[i]);
            maxSum = (curSum > maxSum ? curSum : maxSum);
        }

        return maxSum;
    }

    public int sumArray(int[] array) {
        int counter = 0;
        int sum = 0;
        while(counter < array.length) {
            sum+=array[counter];
            counter++;
        }

        return sum;
    }
}
