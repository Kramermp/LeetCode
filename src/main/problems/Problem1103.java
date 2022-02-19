package main.problems;

public class Problem1103 {

    public int[] distributeCandies(int candies, int numPeople) {
        int remainingCandies = candies;
        int[] candyDistributions = new int[numPeople];
        int currentDistribution = 1;

        while (remainingCandies > 0) {
            for(int i = 0; i <  candyDistributions.length; i++) {
                if(currentDistribution > remainingCandies) {
                    candyDistributions[i]+=remainingCandies;
                    remainingCandies-=remainingCandies;
                    break;
                } else {
                    candyDistributions[i]+=currentDistribution;
                    remainingCandies-=currentDistribution;
                    currentDistribution++;
                }

            }
        }
        return candyDistributions;
    }
}
