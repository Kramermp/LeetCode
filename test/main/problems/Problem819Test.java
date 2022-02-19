package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem819Test {

    @Test
    void testSimple() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String expected = "ball";

        assertEquals(expected, new Problem819().mostCommonWord(paragraph, banned));
    }

    @Test
    void stuff() {

        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob", "hit"};
        String expected = "ball";

        assertEquals(expected, new Problem819().mostCommonWord(paragraph, banned));

    }
}