package main.problems;

public class Problem273 {
    public String numberToWords(int num) {
        //System.out.println("Number to words on " + num);
        if(num < 100) {
            return helper(num);
        }

        String result = "";
        int[] factors = {1000000, 1000, 100, 10, 1};
        int digit = 0;
        int factorIndex = 0;
        while(num > 0 && factorIndex < factors.length) {
            digit = (int) Math.floor(num / factors[factorIndex]);
            if(digit != 0) {
                result = result + numberToWords(digit) + tensFactor(factorIndex);
                System.out.println(digit);
                num = num - (factors[factorIndex] * digit);
            }
            factorIndex++;
        }

        return result.trim();
    }

    private String tensHelper(int digit) {
        String result = "";
        int modResult = digit % 10;
        switch ((int)Math.floor(digit / 10)) {
            case 2:
                result = " twenty";
                break;
            case 3:
                result =" thirty";
                break;
            case 4:
                result = " forty";
                break;
            case 5:
                result = " fifty";
                break;
            case 6:
                result = " sixty";
                break;
            case 7:
                result = " seventy";
                break;
            case 8:
                result = " eighty";
                break;
            case 9:
                result = " ninety";
                break;
            default:
                return "";
        }
        return (modResult == 0 ? result : result + numberToWords(modResult));

    }

    private String helper(int num) {
        if(num>20) {
            return tensHelper(num);
        }
        switch (num) {
            case 1:
               return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                return "";
        }
    }

    public String tensFactor(int factorIndex) {
        switch (factorIndex) {
            case 2:
                return " hundred";
            case 1:
                return " thousand";
            case 0:
                return " million";
            default:
                return "";
        }
    }

}
