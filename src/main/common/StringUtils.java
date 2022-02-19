package main.common;

public class StringUtils {

    public static boolean containsLowerCase(String string) {
        for(int i = 0; i < string.length(); i++) {
            if(Character.isLowerCase(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperCase(String string) {
        for(int i = 0; i < string.length(); i++) {
            if(Character.isUpperCase(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static  boolean containsDigit(String string) {
        for(int i = 0; i < string.length(); i++) {
            if(Character.isDigit(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }


    public static boolean containsRepeatedChars(String string, int count) {
        if(string.length() < count) {
            return  false;
        } else {
            char curChar = string.charAt(0);
            int runningCount = 0;
            for(int i = 0; i < string.length(); i++) {
                if(curChar == string.charAt(i)) {
                    runningCount++;
                    if(runningCount >= count) {
                        return true;
                    }
                } else {
                    runningCount = 0;
                    curChar = string.charAt(i);
                }
            }
        }

        return false;
    }

    public static int getRepeatedIndex(String string, int count) {
        if(string.length() < count || string.length() == 0) {
            return  -1;
        } else {
            char curChar = string.charAt(0);
            int runningCount = 0;
            for(int i = 0; i < string.length(); i++) {
                if(curChar == string.charAt(i)) {
                    runningCount++;
                    if(runningCount == count) {
                        return i - (runningCount - 1); //-1 to convert to 0 index
                    }
                } else {
                    runningCount = 1;
                    curChar = string.charAt(i);
                }
            }
        }

        return -1;
    }

}
