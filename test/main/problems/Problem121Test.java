package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem121Test {

    @Test
    void maxProfit() {
        int[] prices = new int[]{7,1,5,3,6,4};
        assertEquals(5, new Problem121().maxProfit(prices));
    }

    @Test
    void maxProfitNone() {
        int[] prices = new int[]{7,6,4,3,1};
        assertEquals(0, new Problem121().maxProfit(prices));
    }

    @Test
    void maxProfitSimple() {
        int[] prices = new int[]{1,2};
        assertEquals(1, new Problem121().maxProfit(prices));
    }
}