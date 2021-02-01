package com.justynsoft.da.integer;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        System.out.println(divide(1
                , 1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if(dividend == divisor){
            return 1;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);


        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);



        int result = 0;
        while (dividendL >= divisorL) {
            int shift = 0;
            while (dividendL >= (divisorL << shift)) {
                shift = shift + 1;
            }
            dividendL = dividendL - (divisorL << (shift -1));
            result = result + (1 << (shift - 1));
        }

        return isNegative? -result: result;
    }


    public static int divideOLD(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
        }

        if (dividend == Integer.MAX_VALUE) {
            if (divisor == 1) {
                return Integer.MAX_VALUE;
            } else if (divisor == -1) {
                return Integer.MIN_VALUE;
            }
        }
        if (dividend == 0 || Math.abs(dividend) < Math.abs(divisor)) {
            return 0;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);


        //use shift to divide dividend /2 till less than divisor
        long reminder = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);
        int counter = 0;
        while (reminder > divisorL) {
            counter = counter + 1;
            reminder >>= 1;
            if (reminder <= divisorL) {
                //if reminder is less than divisor, we got the position, break
                break;
            }
        }

        counter = counter + 1;
        return isNegative ? -counter : counter;
    }
}
