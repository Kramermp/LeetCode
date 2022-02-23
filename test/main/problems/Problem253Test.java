package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem253Test {

    @Test
    void minMeetingRooms() {
        int[][] input = {{0,30},{5,10},{15,20}};
        int expected = 2;

        assertEquals(expected, new Problem253().minMeetingRooms(input));
    }
}