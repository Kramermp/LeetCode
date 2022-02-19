package main.problems;

import java.util.Random;

public class Problem420 {
    static char variableChar = 257;



    public int strongPasswordChecker(String password) {
        boolean[] containsChecks = new boolean[4];

        StringBuilder sb = new StringBuilder(password);

        int steps = 0;

        updateArray(containsChecks, sb.toString());
        while (!containsChecks[0] || !containsChecks[1] || !containsChecks[2] || !containsChecks[3]
                || !(sb.length() >=6) || !(sb.length() <= 20)) {
            System.out.println(sb.toString());
            if(sb.length() < 6) {
                System.out.println("Short: " + sb.toString());
                if(!containsChecks[0]) {
                    if(!containsChecks[3]) {
                        // If there is Repeated Chars we can break repeated
                        sb.insert(getRepeatedIndex(sb.toString(), 3) + 2, "1");
                        //int = getRepeatedIndex();

                    } else {
                        //If there is no repeated Chars we just add at end
                        sb.append("1");
                    }
                } else if (!containsChecks[1]) {
                    if(!containsChecks[3]) {
                        // If there is Repeated Chars we can break repeated
                        sb.insert(getRepeatedIndex(sb.toString(), 3) + 2, "a");

                    } else {
                        //If there is no repeated Chars we just add at end
                        sb.append("a");
                    }
                } else if (!containsChecks[2]) {
                    if(!containsChecks[3]) {
                        // If there is Repeated Chars we can break repeated
                        sb.insert(getRepeatedIndex(sb.toString(), 3) + 2, "A");

                    } else {
                        //If there is no repeated Chars we just add at end
                        sb.append("A");
                    }
                } else {
                    if(!containsChecks[3]) {
                        // If there is Repeated Chars we can break repeated
                        int index = getRepeatedIndex(sb.toString(), 3);
                        sb.insert(index + 2, (char)(sb.charAt(index) + 1));

                    } else {
                        //If there is no repeated Chars we just add at end
                        char nextChar = variableChar;
                        sb.append(nextChar);
                    }
                }
            } else if (sb.length() > 20) {
//                System.out.println("TooLong: " + sb.toString());

                if(!containsChecks[3]) {
                    //System.out.println(sb.toString());
                    int index = getRepeatedIndex(sb.toString(), 3) + 2;
                    if(!containsChecks[0]) {
                        sb.replace(index, index + 1, "1");
                    } else if (!containsChecks[1]) {
                        sb.replace(index, index + 1, "a");
                    } else if(!containsChecks[2]) {
                        sb.replace(index, index + 1, "A");
                    } else {
                        int repeatCount = getRepeats(index - 2, sb.toString());
                        if(repeatCount > 4 && sb.length() - repeatCount >
                                20) {
                            //System.out.println("Replace is better.");
                            sb.replace(index, index + 1, String.valueOf(variableChar));
                        } else {
                            sb.deleteCharAt(index);
                        }
                    }
                } else {
                    if(!containsChecks[0]) {
                        int index = findNextInSig(sb.toString());
                        sb.deleteCharAt(index);
                        sb.insert(index, '1');
                    } else if (!containsChecks[1]) {
                        int index = findNextInSig(sb.toString());
                        sb.deleteCharAt(index);
                        sb.insert(index, 'a');
                    } else if(!containsChecks[2]) {
                        int index = findNextInSig(sb.toString());
                        sb.deleteCharAt(index);
                        sb.insert(index, 'A');
                    } else {
                        sb.deleteCharAt(findNextInSig(sb.toString()));
                    }
                }
            } else {
                // Length is Good Strictly Replace
                if(!containsChecks[3]) {
                    //.out.println("Just Right: " + sb.toString());
                    if(!containsChecks[0]) {
                        int index = getRepeatedIndex(sb.toString(), 3) + 2;
                        sb.replace(index, index + 1, "1");
                    } else if (!containsChecks[1]) {
                        int index = getRepeatedIndex(sb.toString(), 3) + 2;
                        sb.replace(index, index + 1, "a");
                    } else if(!containsChecks[2]) {
                        int index = getRepeatedIndex(sb.toString(), 3) + 2;
                        sb.replace(index, index + 1, "A");
                    } else {
                        int index = getRepeatedIndex(sb.toString(), 3) + 2;
                        char targetChar = sb.charAt(index);
                        sb.deleteCharAt(index);
                        sb.insert(index, variableChar);
                    }

                } else {
                    if(!containsChecks[0]) {
                        int index = findNextInSig(sb.toString());
                        sb.deleteCharAt(index);
                        sb.insert(index, '1');
                    } else if (!containsChecks[1]) {
                        int index = findNextInSig(sb.toString());
                        sb.deleteCharAt(index);
                        sb.insert(index, 'a');
                    } else if(!containsChecks[2]) {
                        int index = findNextInSig(sb.toString());
                        sb.deleteCharAt(index);
                        sb.insert(index, 'A');
                    }
                }


            }
            steps++;
            updateArray(containsChecks, sb.toString());
        }

        System.out.println("End: " + sb.toString());
        return steps;
    }

    private int getRepeats(int start, String string) {
        int runningCount = 0;
        if(string.length() < start || string.length() == 0) {
            return  -1;
        } else {
            char curChar = string.charAt(start);
            for(int i = start; i < string.length(); i++) {
                if(curChar == string.charAt(i)) {
                    runningCount++;
                } else {
                    return runningCount;
                }
            }
        }

        return runningCount;
    }

    private void updateArray(boolean[] containsChecks, String password) {
        containsChecks[0] = containsDigit(password); //Contains Digit
        containsChecks[1] = containsLowerCase(password);
        containsChecks[2] = containsUpperCase(password);
        containsChecks[3] = !containsRepeatedChars(password, 3); // We want to NOT Contain repeated chars
    }

    public boolean containsLowerCase(String string) {
        for(int i = 0; i < string.length(); i++) {
            if(Character.isLowerCase(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean containsUpperCase(String string) {
        for(int i = 0; i < string.length(); i++) {
            if(Character.isUpperCase(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDigit(String string) {
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
                    if(runningCount >= count && curChar != variableChar) {
                        return true;
                    }
                } else {
                    runningCount = 1;
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
                    if(runningCount == count && curChar != variableChar) {
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

    int findNextInSig(String string) {
        int digitCount = 0;
        int upperCount = 0;
        int lowerCount = 0;

        char curChar = 'a';
        for(int i = 0; i < string.length() - 1; i++){
            curChar = string.charAt(i);
            if(curChar == variableChar) {
                // Do nothing to variable Chars
            } else {
                if(Character.isDigit(curChar)){
                    digitCount++;
                    if(digitCount >= 2 && validNeighbor(i, string)) {
                        return i;
                    }
                } else if(Character.isUpperCase(curChar)){
                    upperCount++;
                    if(upperCount >= 2 && validNeighbor(i, string)) {
                        return i;
                    }
                } else if (Character.isLowerCase(curChar)){
                    lowerCount++;
                    if(lowerCount >= 2 && validNeighbor(i, string)) {
                        return i;
                    }
                }
            }
        }

        return 0;
    }

    public static boolean validNeighbor(int i,String string) {
        if (i == 0) {
            return true;
        } else if (i == string.length() - 1) {
            return true;
        } else {
            int lowerBounds = (i >= 2 ? 2 : 1);
            int upperBounds = (string.length() - i >= 2 ? 2 : 1);

            char curChar = string.charAt(i - lowerBounds);
            int runningCount = 0;
            for(int j = i - lowerBounds; j <= i + upperBounds; j++) {
                if (j == i) {
                    // Skip Test Char
                } else {
                    if (string.charAt(j) == curChar) {
                        runningCount++;
                        if(runningCount == 3) {
                            return false;
                        }
                    } else {
                        curChar = string.charAt(j);
                        runningCount = 1;
                    }
                }
            }
            return true;
        }
    }
}


