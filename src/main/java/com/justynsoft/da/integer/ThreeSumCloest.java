package com.justynsoft.da.integer;

import java.util.Arrays;

public class ThreeSumCloest {
    public static void main(String[] args){
        //int[] testArr  = new int[]{1,1,-1,-1,3 };
        int[] testArr  = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(testArr, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return -1;
        }

        int mininum = 0;
        int miniPos = 0;
        Arrays.sort(nums);
        for(int i = 0;  i < nums.length -2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int rest = target - nums[i] ;
            int leftPos = i +1;
            int rightPos = nums.length -1;
            while( leftPos < rightPos){
                if(nums[leftPos] + nums[rightPos] == rest){
                    return nums[leftPos] + nums[rightPos] + nums[i];
                }else if(nums[leftPos] + nums[rightPos] < rest){
                    if(mininum == 0 || Math.abs(nums[leftPos] + nums[rightPos] + nums[i] - target) < Math.abs(mininum) ){
                        mininum = Math.abs(nums[leftPos] + nums[rightPos] + nums[i] - target);
                        miniPos = nums[leftPos] + nums[rightPos] + nums[i];
                    }
                    leftPos++;
                }else{
                    if(mininum == 0 || Math.abs(nums[leftPos] + nums[rightPos] + nums[i] - target)< Math.abs(mininum) ){
                        mininum = Math.abs(nums[leftPos] + nums[rightPos] + nums[i] - target);
                        miniPos = nums[leftPos] + nums[rightPos] + nums[i];
                    }
                    rightPos--;
                }
            }
        }
        return miniPos;


    }
}
