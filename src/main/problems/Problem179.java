package main.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem179 {
    boolean notAllZeros = false;
    StringBuilder sb = new StringBuilder();
    NumEntry[] neArray = null;

    public String largestNumber(int[] nums) {
        neArray = new NumEntry[nums.length];

        for(int i = 0; i < nums.length; i++) {
            neArray[i] = new NumEntry(nums[i]);
            if(!notAllZeros && nums[i] != 0) {
                notAllZeros = true;
            }
        }

        Arrays.sort(neArray);
        for(int i = 0; i < neArray.length; i++) {
            sb.append(neArray[i].numValue);
        }

        return notAllZeros ? sb.toString() : "0";
    }


    protected static class NumEntry implements Comparable<NumEntry> {
        int numValue = 0;
        int[] digits = null;

        NumEntry(int numValue) {
            this.numValue = numValue;
            setDigits();
        }

        private void setDigits(){
            digits = new int[getDigitCount()];
            //Build Array Backwards so that digits[0] is the leftmost digit
            int remainder = numValue;
            for(int i = (digits.length - 1); i >= 0; i--) {
                digits[i] = remainder % 10;
                remainder = (int) Math.floor(remainder / 10);
            }
        }

        //Lolol found this pre computed and appearently benchmarks well
        private int getDigitCount() {
            if (numValue < 100000) {
                if (numValue < 100) {
                    if (numValue < 10) {
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    if (numValue < 1000) {
                        return 3;
                    } else {
                        if (numValue < 10000) {
                            return 4;
                        } else {
                            return 5;
                        }
                    }
                }
            } else {
                if (numValue < 10000000) {
                    if (numValue < 1000000) {
                        return 6;
                    } else {
                        return 7;
                    }
                } else {
                    if (numValue < 100000000) {
                        return 8;
                    } else {
                        if (numValue < 1000000000) {
                            return 9;
                        } else {
                            return 10;
                        }
                    }
                }
            }
        }

        @Override
        public int compareTo(NumEntry numEntry) {
            // I am inverting the compare to rather than creating a comparator
            return straightCompare(numEntry) * -1;
        }

        private int straightCompare(NumEntry numEntry) {
            // Repeat till we get an answer
            for(int i = 0; i <= digits.length * 2 || i <= numEntry.digits.length * 2; i++) {
                if(this.getIndex(i) > numEntry.getIndex(i)) {
                    return 1;
                } else if(this.getIndex(i) < numEntry.getIndex(i)) {
                    return -1;
                };
            }
            return (digits.length == numEntry.digits.length ? 0 : (digits.length > numEntry.digits.length ? 1 : -1));
        }

        public int getIndex(int digitToGet) {
            if(digitToGet < digits.length) {
                return digits[digitToGet];
            }
            int loopCount = (int) Math.floor(digitToGet / digits.length);
            digitToGet = digitToGet - (loopCount * digits.length);

            return digits[digitToGet];
        }
    }
}
