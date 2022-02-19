package main.problems;

public class Problem121 {

    public int maxProfit(int[] prices) {
        return prices.length <= 1 ? 0 : getProfits(prices);
    }

    private int getProfits(int[] prices) {
        int minBuy = prices[0];
        int maxDiff = prices[1] - prices[0];
        int curDiff = 0;

        for(int i = 1; i < prices.length; i++) {
            minBuy = (prices[i] < minBuy ? prices[i] : minBuy);
            curDiff = (prices[i] - minBuy);
            maxDiff = (curDiff > maxDiff ? curDiff : maxDiff);
        }

        return maxDiff;
    }
}
