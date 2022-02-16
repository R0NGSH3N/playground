package com.justynsoft.da.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class Add2Binary {

    public static void main(String[] args){
        System.out.println(" 0 % 2 " + (0%2));
        System.out.println(" 1 % 2 " + (1%2));
        System.out.println(" 2 % 2 " + (2%2));
        System.out.println(" 3 % 2 " + (3%2));
        add2Binary();
    }

    public static void add2Binary(){
        String a = "11001";
        String b = "100";
        String result = "";
        char rs = '0';

        for(int i = 0; i < (a.length() > b.length() ? a.length() : b.length()); i++){
            char ac = i < a.length() ? a.charAt(a.length() -1 - i) : '0';
            char bc = i < b.length() ? b.charAt(b.length() -1 - i) : '0';
            char ss = (char)((ac ^ bc ) ^ rs);
            result = ss + result;
            rs = (char)((ac & bc) | rs);
            System.out.println(rs);
        }

        if( rs != 0){
            result = rs + result;
        }

        System.out.println("result : " + result);
    }


    public static void add2Binary2(){
        int carry = 0 , digit = 0;
//        Integer.parseInt()

        System.out.println(" 3 % 2 " + (3%2));
    }
}
