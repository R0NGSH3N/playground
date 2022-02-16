package com.justynsoft.da;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2017/4/8.
 */
public class TidyNumber {

    public static void main (String[] args){

        //Long test = 989L;
        //Long test = 132L;
        Long test = 111111110L;


        ArrayList<Long> testArray = convert(test);

        while(!isTidy(testArray)){
            System.out.println("isTide:" +  isTidy(testArray));
            tidyNumber(testArray);
        }

        System.out.println(testArray);


    }

    public static ArrayList tidyNumber(ArrayList<Long> test){
        Long previous = null;
        for(int i = 0 ; i < test.size() ; i++){
            Long curr = test.get(i);
            if(previous != null && curr < previous){
                //find the break;
                test.set(i - 1, previous - 1);
                for(int j = i; j < test.size() ; j++){
                    test.set(j, 9L);
                }
            }else{
                previous = curr;
            }
        }

        return test;
    }

     static Boolean isTidy(ArrayList<Long> arrayTest){
        Long previous = null;
        for(Long curr: arrayTest){
            if(previous != null && curr < previous){
                return false;
            }else{
                previous = curr;
            }
        }

        return true;
    }

    public static ArrayList<Long> convert(Long test){
        //int length = test.toString().length();
        ArrayList<Long> arr = new ArrayList<>();
        while(test > 0){
            arr.add(test % 10 );
            test = test / 10;
        }

        Collections.reverse(arr);
        for(Long i : arr){
            System.out.println(i);
        }

        return arr;

    }




}
