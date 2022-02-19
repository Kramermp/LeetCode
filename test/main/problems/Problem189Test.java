package main.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem189Test {

    @Test
    void rotateEx1() {
        int[] inputArray = new int[]{1,2,3,4,5,6,7};
        int rotateCount = 3;
        int[] expectedReturn = new int[] {5,6,7,1,2,3,4};
        new Problem189().rotate(inputArray, rotateCount);

        Assertions.assertArrayEquals(expectedReturn, inputArray);
    }

    @Test
    void rotateEx2() {
        int[] inputArray = new int[]{-1,-100,3,99};
        int rotateCount = 2;
        int[] expectedReturn = new int[] {3,99,-1,-100};
        new Problem189().rotate(inputArray, rotateCount);

        Assertions.assertArrayEquals(expectedReturn, inputArray);
    }
}