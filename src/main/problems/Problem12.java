package main.problems;

import java.util.Map;

public class Problem12 {

    protected int[] denum = {1,5,10,50,100,500,1000};
    protected String[] chars = {"I","V","X","L","C", "D", "M"};

    public String intToRoman(int num) {
        int remainder = num;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int offSet = 0;

        for(int i = denum.length - 1; i >= 0 && remainder != 0; i--) {
            count = (int) Math.floor(remainder / denum[i]);

            for(int j = 0; j < count; j++) {
                sb.append(chars[i]);
            }
            remainder = remainder - (count * denum[i]);
            //Check for Subtractions
            if(i >= 1) {
                offSet = ((i % 2 == 0) ? 2 : 1); // 2 for Even : 1 for Odd
                if(remainder >= denum[i] - denum[i - offSet]) {
                    sb.append(chars[i - offSet] + chars[i]);
                    remainder = remainder - (denum[i] - denum[i - offSet]);
                }
            }
        }
        return sb.toString();
    }
}
