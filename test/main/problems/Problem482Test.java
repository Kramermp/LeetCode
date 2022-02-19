package main.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem482Test {


    @Test
    void licenseKeyFormatting() {

        String input = "5F3Z-2e-9-w";
        int groupCount = 4;
        String expectedResult =  "5F3Z-2E9W";

        assertEquals(expectedResult, new Problem482().licenseKeyFormatting(input, groupCount));
    }

    @Test
    void licenseKeyex2() {

        String input = "2-5g-3-J";
        int groupCount = 2;
        String expectedResult =  "2-5G-3J";

        assertEquals(expectedResult, new Problem482().licenseKeyFormatting(input, groupCount));
    }


}