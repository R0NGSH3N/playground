package com.justynsoft.da.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayInsertionI {
    public static void main(String[] args){
       int[] original = new int[]{ 1, 2,3, 4, 5, 6, 7, 8};
       int[] result = new int[original.length ];

       System.arraycopy(original, 0, result, 0, 4);
       System.out.println("new array" + result);


    }
}
