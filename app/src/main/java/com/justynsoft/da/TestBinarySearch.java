package com.justynsoft.da;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class TestBinarySearch {

    public static void main(String[] args){
        int[] testArray = {2,4,6,8,8,8,8,8,10,12};

        TestBinarySearch tbs = new TestBinarySearch();
        if(tbs.findTarget(testArray, 0, testArray.length, 18) != -1){
            System.out.print("found");
        }else{
            System.out.println("not Found");
        }

    }

    public int findTarget(int[] sourceArray, int leftPos, int rightPos, int target){
        if(rightPos > leftPos){

            int midPos = leftPos + (rightPos - leftPos)/2;
            if(target == sourceArray[midPos]){
                /**
                for(int i = midPos; i < sourceArray.length ;  i++){
                   if(target == sourceArray[i]){
                       midPos = i;
                   }else{
                       break;
                   }
                }
                 **/
                return midPos;
            }

            if(target > sourceArray[midPos]){
                return findTarget(sourceArray,midPos +1, rightPos, target);
            }

            return findTarget(sourceArray, leftPos, midPos -1, target);
        }

        return -1;
    }
}
