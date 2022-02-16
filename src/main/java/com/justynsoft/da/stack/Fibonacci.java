package com.justynsoft.da.stack;

/**
 * Created by rongshen on 2/2/15.
 */
public class Fibonacci {

    public static int fib(int i){
        if( i == 0){
            return 0;
        }else if( i == 1){
            return 1;
        }else{
            return fib(i - 1) + fib( i - 2);
        }
    }

    public static void main (String[] args){
        for(int i = 0; i <= 10; i++){
            System.out.printf("%d,",fib(i));
        }
    }
}
