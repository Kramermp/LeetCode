package main.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem53Test {

    @Test
    void maxSubArrayEx1() {
        int[]  input = new int[] {-2,1,-3,4,-1,2,1,-5,4};

        Assertions.assertEquals(6, new Problem53().maxSubArray(input));
    }

    @Test
    void maxSubArrayEx2() {
        int[]  input = new int[] {1};

        Assertions.assertEquals(1, new Problem53().maxSubArray(input));
    }

    @Test
    void maxSubArrayEx3() {
        int[]  input = new int[] {5,4,-1,7,8};

        Assertions.assertEquals(23, new Problem53().maxSubArray(input));
    }

    @Test
    void maxSubArrayEx4() {
        int[]  input = new int[] {-2,1};

        Assertions.assertEquals(1, new Problem53().maxSubArray(input));
    }

    @Test
    void maxSubArrayEx5() {
        int[]  input = new int[] {-1,0,-2};

        Assertions.assertEquals(0, new Problem53().maxSubArray(input));
    }

}