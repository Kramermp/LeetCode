package main.problems;

import main.assessments.Assessment1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem957Test {

    @Test
    void testSimpleBulk() {
        int[] cells = {1,0,0,1,0,0,1,0};
        int n = 1000000000;
        int[] results = {0,0,1,1,1,1,1,0};

        Assertions.assertArrayEquals(results, new Problem957().prisonAfterNDays(cells, n));
    }


}