package main.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMathStuffsTest {

    @Test
    void calculateMidOne() {
        Assertions.assertEquals(0, SimpleMathStuffs.calculateMid(1));
    }

    @Test
    void calculateEven() {
        Assertions.assertEquals(2, SimpleMathStuffs.calculateMid(4));
    }

    @Test
    void calculateOdd() {
        Assertions.assertEquals(3, SimpleMathStuffs.calculateMid(5));
    }


    @Test
    void reflectIndexTest() {
        assertEquals(3, SimpleMathStuffs.reflectIndex(3, 7));
        assertEquals(4, SimpleMathStuffs.reflectIndex(4, 7));
        assertEquals(3, SimpleMathStuffs.reflectIndex(5, 7));
        assertEquals(1, SimpleMathStuffs.reflectIndex(14, 7));
    }

}