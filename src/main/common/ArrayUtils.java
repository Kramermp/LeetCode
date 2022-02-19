package main.common;

public class ArrayUtils {

    public int sumArray(int[] array) {
        int counter = 0;
        int sum = 0;
        while(counter < array.length) {
            sum+=array[counter];
            counter++;
        }

        return sum;
    }
}
