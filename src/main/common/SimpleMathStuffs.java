package main.common;

public class SimpleMathStuffs {

    public static int calculateMid (int length) {
        return (int) Math.floor((length / 2d));
    }

    public static int reflectIndex(int index, int length) {

        return index > Math.ceil(length / 2d) ? (int) (Math.ceil(length / 2d) - (index - Math.ceil(length / 2d))) : index;
    }


}
