package com.justynsoft.da.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args){
        //int[] testArr = new int[]{-1, 0, 1, 2, -1, -4};
        int[] testArr = new int[]{-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        List result = threeSum(testArr);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //first sort the array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return result;
        }

        //start the first element
        for(int i = 0 ; i <  nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int rest =  0 - nums[i];
            int leftPos = i + 1;
            int rightPos = nums.length -1;
            while( leftPos < rightPos ){
                if(nums[leftPos] + nums[rightPos] ==  rest){
                    List<Integer> item = new ArrayList<Integer>();
                    item.add(nums[i]);
                    item.add(nums[leftPos]);
                    item.add(nums[rightPos]);
                    result.add(item);
                    leftPos++;
                    rightPos--;
                    while(leftPos < rightPos && nums[leftPos] == nums[leftPos -1]){
                        leftPos++;
                    }
                    while(leftPos < rightPos && nums[rightPos] == nums[rightPos + 1]){
                        rightPos--;
                    }
                }else if (nums[leftPos] +  nums[rightPos] < rest){
                    leftPos++;
                }else{
                    rightPos--;
                }
            }
        }
        return result;
    }

}
