package com.justynsoft.da.integer;

public class IntegerToRoman {

    public static void main(String[] args){
        //System.out.println(700 / 500);
        //System.out.println(intToRoman(1994));
        //System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
    }

    public static String intToRoman(int num){
        if(num <= 0){
            return "";
        }
        int number[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String symbol[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while(num > 0){
           int currD = num / number[index];
           num  = num - currD * number[index];
           while(currD > 0){
               sb.append(symbol[index]);
               currD--;
           }

           index++;

        }


        return sb.toString();
    }

}
