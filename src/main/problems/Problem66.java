package main.problems;

import java.util.Arrays;

public class Problem66 {
    int curIndex = 0;
    public int[] plusOne(int[] digits) {
        return increment(0, 1, digits);
    }

    private int[] increment(int index, int amount, int[] digits) {
        curIndex = digits.length - 1 - index;
        digits[curIndex]+= amount;
        if(digits[curIndex] == 10) {
            digits[curIndex] = 0;
            if(curIndex == 0) {
                int[] newDigits = Arrays.copyOf(digits, digits.length + 1);

            } else {
                return increment(index + 1, amount, digits);
            }
        }

        return digits;
    }
}
