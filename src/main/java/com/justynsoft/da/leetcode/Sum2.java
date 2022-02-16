package com.justynsoft.da.leetcode;

import java.util.Arrays;

/**
 * Created by rongshen on 8/12/15.
 */
public class Sum2 {
    public static void main(String[] args){
        sum2();
    }

    public static void sum2(){
        int[] arr = {2,3,7,8,5};
        int target = 15;
        outer: for(int i  = 0 ;  i < arr.length; i++){
            int secondNum = target - arr[i];
            for(int j = i +1 ; j < arr.length; j++){
                if(secondNum == arr[j]){
                    System.out.println("found them: i : " + (i+1) + "j: " + (j+1) );
                    break outer;
                }
            }
        }
    }

    public static void sum2pointers(){
        int[] arr = {2,3,7,8,5};
        int target = 15;
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        boolean found = false;
        int lp = 0 ;
        int hp = sortedArr.length -1;
        while(found){
            int low = sortedArr[lp];
            int high = sortedArr[hp];
            if( low +  high == target){
                System.out.println("found ");
            }else if(low + high < target){
                lp++;
            }else{
                hp++;
            }
        }
    }

    //public static void sum2hashmap()
}
