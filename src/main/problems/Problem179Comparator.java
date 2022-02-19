package main.problems;

import java.util.Arrays;
import java.util.HashMap;

public class Problem179Comparator {
    boolean containsNonZeros = false;
    int[] digits1 = null;
    int[] digits2 = null;
    HashMap<Integer, int[]> digitMap = new HashMap<>();

    public String largestNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                containsNonZeros = true;
                i = nums.length;
            }
        }
        if(!containsNonZeros) {
            return "0";
        }

        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedNums, (integer, t1) -> {
            if(integer == t1) {
                return 0;
            }

            digits1 = (digitMap.get(integer) == null ? calculateDigits(integer) : digitMap.get(integer));
            digits2 = (digitMap.get(t1) == null ? calculateDigits(t1) : digitMap.get(t1));;

            // Repeat till we get an answer
            for(int i = 0; i <=  digits1.length * 2|| i <= digits2.length * 2; i++) {
                if(getIndex(i, digits1) > getIndex(i, digits2)) {
                    return -1;
                } else if(getIndex(i, digits1) < getIndex(i, digits2)) {
                    return 1;
                }
            }
            return (digits1.length == digits2.length ? 0 : (digits1.length > digits2.length ? -1 : 1));
        });



        return Arrays.stream(boxedNums).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

    }

    private int[] calculateDigits(int integer) {
        if(integer < 10) {
            return new int[] {integer};
        }
        int[] digits = new int[getDigitCount(integer)];
        //Build Array Backwards so that digits[0] is the leftmost digit
        int remainder = integer;
        for(int i = (digits.length - 1); i >= 0; i--) {
            digits[i] = remainder % 10;
            remainder = (int) Math.floor(remainder / 10);
        }
        return digits;
    }

    private int getDigitCount(Integer integer) {
        if (integer < 100000) {
            if (integer < 100) {
                if (integer < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (integer < 1000) {
                    return 3;
                } else {
                    if (integer < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (integer < 10000000) {
                if (integer < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (integer < 100000000) {
                    return 8;
                } else {
                    if (integer < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }

    public int getIndex(int digitToGet, int[] digitArray) {
        if(digitToGet < digitArray.length) {
            return digitArray[digitToGet];
        }
        int loopCount = (int) Math.floor(digitToGet / digitArray.length);
        digitToGet = digitToGet - (loopCount * digitArray.length);

        return digitArray[digitToGet];
    }

}
