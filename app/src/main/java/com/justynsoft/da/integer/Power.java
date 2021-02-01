package com.justynsoft.da.integer;

public class Power {
    public static void main(String[] args) {
        System.out.println(myPow(2, 8));

    }

    public double power(double x, int n){
        if( n == 0){
            return 1;
        }

        double v = power(x, n/2);

        if(n % 2 == 0){
            return v * v;
        }else{
            return v * v * x;
        }
    }

    public static double myPow(double x, int n) {
        double result = 1.0d;
        if (n == 0) {
            return result;
        } else if (n == 1) {
            return x;
        }

        if (n < 0) {
            result = 1 /power(0, 0, x, x, result, -n);
            return result;
        } else {
            return power(0,0,x, x,result, n);
        }


    }

    public static double power(int count, int sum, double x, double original, Double result, int n) {
        if (sum == n) {
            return result;
        } else if (sum == n - 1) {
            result *= original;
            return result;
        } else {
            double value = x * x;
            result *= value;
            count += 1;
            sum += count * 2;
            result = power(count, sum, value, original, result, n);
            return result;
        }

    }
}
