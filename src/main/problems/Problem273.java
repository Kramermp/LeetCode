package main.problems;

public class Problem273 {
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        //System.out.println("Number to words on " + num);
        if(num < 100) {
            return helper(num);
        }

        String result = "";
        int[] factors = {1000000000, 1000000, 1000, 100, 1};
        int digit = 0;
        int factorIndex = 0;
        while(num > 0 && factorIndex < factors.length) {
            digit = (int) Math.floor(num / factors[factorIndex]);
            if(digit != 0) {
                result = result +" " + numberToWords(digit) + " " + tensFactor(factorIndex);
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
                result = "Twenty";
                break;
            case 3:
                result =  "Thirty";
                break;
            case 4:
                result = "Forty";
                break;
            case 5:
                result = "Fifty";
                break;
            case 6:
                result = "Sixty";
                break;
            case 7:
                result = "Seventy";
                break;
            case 8:
                result = "Eighty";
                break;
            case 9:
                result = "Ninety";
                break;
            default:
                return "";
        }
        return (modResult == 0 ? result : result + " " + numberToWords(modResult));

    }

    private String helper(int num) {
        if(num>=20) {
            return tensHelper(num);
        }
        switch (num) {
            case 1:
               return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            default:
                return "";
        }
    }

    public String tensFactor(int factorIndex) {
        switch (factorIndex) {
            case 3:
                return "Hundred";
            case 2:
                return "Thousand";
            case 1:
                return "Million";
            case 0:
                return "Billion";
            default:
                return "";
        }
    }

}
