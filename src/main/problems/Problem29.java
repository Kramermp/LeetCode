package main.problems;

//Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
public class Problem29 {
    public int divide(int dividend, int divisor) {
        if(divisor == 1 || divisor == -1) {
            return dividend;
        }

        int count = 0;
        boolean notSameSign = (dividend > 0 ^ divisor > 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend >= divisor){
            count++;
            dividend-=divisor;
        }
        return notSameSign ? count * -1 : count;
    }
}
