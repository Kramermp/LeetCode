package main.problems;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Problem1157Test {

    @Test
    void queryEx1a() {
        Problem1157 example = new Problem1157(new int[]{1, 1, 2, 2, 1, 1});
        int left = 0;
        int right = 5;
        int threshhold = 4;
        int expectedResult = 1;
        
        assertEquals(expectedResult, example.query(left, right, threshhold));
    }

    @Test
    void queryEx1b() {
        Problem1157 example = new Problem1157(new int[]{1, 1, 2, 2, 1, 1});
        int left = 0;
        int right = 3;
        int threshhold = 3;
        int expectedResult = -1;

        assertEquals(expectedResult, example.query(left, right, threshhold));
    }

    @Test
    void queryEx1c() {
        Problem1157 example = new Problem1157(new int[]{1, 1, 2, 2, 1, 1});
        int left = 2;
        int right = 3;
        int threshold = 2;
        int expectedResult = 2;

        assertEquals(expectedResult, example.query(left, right, threshold));
    }
    @Test
    void queryExFailed1() {
        Problem1157 example = new Problem1157(new int[]{2, 2, 1, 2, 1, 2, 2, 1, 1, 2});
        int left = 0;
        int right = 0;
        int threshold = 0;
        int expectedResult = 0;

        int[][] tests = new int[][]{{2,5,4, -1},
                                    {0,5,6, -1},
                                    {0,1,2, 2},
                                    {2,3,2, -1},
                                    {6,6,1, 2},
                                    {0,3,3, 2},
                                    {4,9,6, -1},
                                    {4,8,4, -1},
                                    {5,9,5, -1},
                                    {0,1,2, 2 }};
        int i = 0;
            for (int[] test: tests) {
                System.out.println("Test :" + i);
                left = test[0];
                right = test[1];
                threshold = test[2];
                expectedResult = test[3];

                assertEquals(expectedResult, example.query(left, right, threshold));
                i++;
            }

    }

    @Test
    void volumeTest()  {

        new File( "test.txt");
        Scanner scnr = null;
        //scnr = new Scanner(new BufferedReader(getClass().getClassLoader().getResourceAsStream("file.txt")));

        InputStream is = getClass().getClassLoader().getResourceAsStream("Problem1157VolumeTestData");
        scnr = new Scanner(is);

        scnr.useDelimiter(",");
        ArrayList<Integer> inputList = new ArrayList<>();

        while(scnr.hasNextInt()) {
            inputList.add(scnr.nextInt());
        }

        Integer[] inputArray = new Integer[inputList.size()];
        Problem1157 example = new Problem1157(inputList.stream().mapToInt(i -> i).toArray());

        int left = 0;
        int right = 19999;
        int threshold = 11366;
        int expectedResult = -1;

        System.out.println("Starting Volume Test");
        assertEquals(expectedResult, example.query(left, right, threshold));
    }

}