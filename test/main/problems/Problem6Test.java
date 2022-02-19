package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    @Test
    void convertEx1() {
        String input = "PAYPALISHIRING";
        int numRows = 3;
        assertEquals("PAHNAPLSIIGYIR", new Problem6().convert(input, numRows));
    }

    @Test
    void convertOneRow() {
        String input = "PAYPALISHIRING";
        int numRows = 1;
        assertEquals("PAYPALISHIRING", new Problem6().convert(input, numRows));
    }
}