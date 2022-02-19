package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem29Test {

    @Test
    void divide() {
        assertEquals(3, new Problem29().divide(10, 3));
        assertEquals(-2, new Problem29().divide(7, -3));
    }

    @Test
    void divideNeg() {
        assertEquals(-2, new Problem29().divide(7, -3));
    }
}