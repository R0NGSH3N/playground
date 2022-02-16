package com.justynsoft.da.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args){
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = fourSum(nums, 0);
        System.out.println(result);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4 ){
           return result;
        }

        Arrays.sort(nums);
        outer: for(int i =  0; i < nums.length - 3; i++){

            int curr = nums[i];
            if( i > 0 && curr == nums[i - 1]){
                continue outer;
            }

            int newTarget = target - curr;
            inner: for(int j = i + 1; j < nums.length - 2 ; j++){
               int currInner = nums[j];
               if(j > i + 1 && currInner == nums[j -1]){
                   continue inner;
               }
               int innerTarget = newTarget - currInner;
               int leftPos = j + 1;
               int rightPos = nums.length - 1;
               while(leftPos < rightPos){
                  if(nums[leftPos] + nums[rightPos] == innerTarget){
                      List<Integer> found = new ArrayList<>();
                      found.add(curr);
                      found.add(currInner);
                      found.add(nums[leftPos]);
                      found.add(nums[rightPos]);
                      result.add(found);

                      leftPos++;
                      rightPos--;
                      while(leftPos < rightPos && nums[leftPos] == nums[leftPos - 1]){
                          leftPos++;
                      }

                      while(leftPos < rightPos && nums[rightPos] == nums[rightPos +1]){
                          rightPos--;
                      }
                  }else if(nums[leftPos] + nums[rightPos] < innerTarget){
                      leftPos++;
                  }else if(nums[leftPos] + nums[rightPos] > innerTarget){
                      rightPos--;
                  }
               }
            }
        }
        return result;
    }
}
