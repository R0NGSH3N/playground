package com.justynsoft.da;

public class TestPrimeParameter {

    public int target;

    public static void main(String[] args){
        TestPrimeParameter obj = new TestPrimeParameter();
        int[] something = {1};
        changeNumber(something);
        System.out.print("target is " + something[0]);

    }

    public static void changeNumber(int[] obj){
        obj[0] = 24;
    }
}
