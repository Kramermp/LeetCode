package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1672Test {

    @Test
    void maximumWealthSame() {
        assertEquals(6, new Problem1672().maximumWealth(new int[][]{{1,2,3},{3,2,1}}));
    }

    @Test
    void maximumWealthStandard() {
        assertEquals(10, new Problem1672().maximumWealth(new int[][]{{1,5},{7,3},{3,5}}));
    }
}