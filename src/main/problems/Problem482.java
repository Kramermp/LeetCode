package main.problems;

public class Problem482 {

    public String licenseKeyFormatting(String string, int groupSize) {
        string = string.replace("-", "");
//        string = string.toUpperCase();

        StringBuilder sb = new StringBuilder();
        int maxIndex = string.length() - 1;// Convert to 0 Index
        int curGroupSize = 0;
        for(int i = maxIndex; i >= 0; i--) {

            sb.append(Character.toUpperCase(string.charAt(i)));
            curGroupSize++;
            if(curGroupSize == groupSize && i != 0) {
                sb.append("-");
                curGroupSize = 0;
            }
        }

        //Remove Check from Loop Because we Only really need to check once
        if(sb.length() != 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }
}
