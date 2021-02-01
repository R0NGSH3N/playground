package com.justynsoft.da.integer;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args){

        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        //int number[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        //String symbol[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int value = 0;
        char[] arry = s.toCharArray();
        for(int i = 0 ; i < arry.length; i++){
            char frstChar = arry[i];
            if( i != arry.length - 1){ //last position
                char sndChar = arry[i +1];
                String queryStr = Character.toString(frstChar) + Character.toString(sndChar);
                if(map.get(queryStr) == null){
                    value = value + map.get(Character.toString(frstChar));
                }else {
                    value += map.get(queryStr);
                    //jump
                    i += 1;
                }
            }else{
                value = value + map.get(Character.toString(frstChar));
            }
        }

        return value;

    }
}
