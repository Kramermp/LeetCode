package main.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Problem588Test {

    @Test
    void mkdir() {
        Problem588.FileSystem test = new Problem588.FileSystem();
        test.mkdir("/test");
        String[] expected  = {"test"};

        assertArrayEquals(expected, test.ls("/").toArray(new String[1]));
    }

    @Test
    void mkdirSimple() {
        Problem588.FileSystem test = new Problem588.FileSystem();
        test.mkdir("/a/b/c");
        String[] expected  = {"c"};;

        assertArrayEquals(expected, test.ls("/a/b").toArray(new String[1]));
    }

    @Test
    void mkdirNoDupes() {
        Problem588.FileSystem test = new Problem588.FileSystem();
        test.mkdir("/a/b/c");
        test.mkdir("/a/b/c");
        String[] expected  = {"c"};;

        assertArrayEquals(expected, test.ls("/a/b").toArray(new String[1]));
    }
    @Test
    void lsSorted() {
        Problem588.FileSystem test = new Problem588.FileSystem();
        test.mkdir("/a/b/a");
        test.mkdir("/a/b/z");
        test.mkdir("/a/b/y");
        test.mkdir("/a/b/c");
        String[] expected  = {"a","c","y","z"};;
        String[] results = test.ls("/a/b").toArray(new String[1]);
        System.out.println(Arrays.toString(results));
        assertArrayEquals(expected, results);
    }


    @Test
    void mkdirFailing() {
        Problem588.FileSystem test = new Problem588.FileSystem();
        test.ls("/");
        test.mkdir("/gh");
        test.mkdir("/e");
        test.mkdir("/jfo");
        test.mkdir("/gh/znflyvnd");
        test.mkdir("/test");
        test.ls("/gh");
        test.addContentToFile("/mhdmck","v");
        String[] expected  = {"test"};

//        assertArrayEquals(expected, test.ls("/").toArray(new String[1]));
    }

    @Test
    void addContentToFile() {
        Problem588.FileSystem test = new Problem588.FileSystem();
        String testPath = "/testPath/test";
        String testString = "test";
        test.addContentToFile(testPath, testString);
        assertEquals(testString, test.readContentFromFile(testPath));
    }

    @Test
    void addContentToFileNoDupes() {
        Problem588.FileSystem test = new Problem588.FileSystem();
        String testPath = "/a/b/c/d";
        String testString = "test";
        test.addContentToFile(testPath, testString);
        test.addContentToFile(testPath, testString);
        String[] expected  = {"d"};;
        String[] results = test.ls("/a/b/c").toArray(new String[1]);
        System.out.println(Arrays.toString(results));
        assertArrayEquals(expected, results);
    }

}