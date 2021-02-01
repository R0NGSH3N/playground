package com.justynsoft.da.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {

    public static void main(String[] args){
        PlusOne obj = new PlusOne();
        System.out.println(Arrays.toString(obj.plusOne( new int[]{4,3,2,1})));
    }

    public int[] plusOne(int[] digits) {
        int reg = 0;
        for(int i = digits.length -1 ; i >= 0; i--){
            int tail = digits[i];
            if(tail == 9){
                digits[i] = 0;
                reg = 1;
            }else{
                digits[i] = digits[i] + 1;
                reg = 0;
                break;
            }
        }

        if(reg == 1){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int i = 0; i < digits.length; i++){
                result[i + 1] = digits[i];
            }
            return result;
        }

        return digits;



        /**
        int tail = digits[digits.length - 1] + 1;
        if(tail >= 10){
            int[] result = new int[digits.length + 1];
            result = Arrays.copyOf(digits, digits.length + 1);
            result[result.length - 2 ] = tail / 10;
            result[result.length - 1 ] = tail % 10;
            return result;
        }else{
            digits[digits.length -  1] = digits[digits.length - 1] + 1;
            return digits;
        }
         **/
        /**
        int result = Integer.MIN_VALUE;
        for(int i = 0 ; i < digits.length; i++){
            if( i != digits.length - 1){
                result += digits[i] * 10 * (digits.length - i - 1) ;
            }else{
                result += digits[i];
            }
        }

        return result + 1;
         **/
    }
}
