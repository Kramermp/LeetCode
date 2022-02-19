package main.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem17Test {

    @Test
    void letterCombinations() {
        List<String> strings = new Problem17().letterCombinations("2");

        for (String curString:
             strings) {
            System.out.println("Cur String: " + curString );
        }
    }
}