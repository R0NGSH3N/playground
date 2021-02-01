package com.justynsoft.da.array;

public class MaximumSubarray {

    public static void main(String[] args){
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArray(a));
    }

    public static int maxSubArray(int[] nums) {
        //Kadane's Algo
        int currentMax = nums[0], result = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            result = Math.max(currentMax, result);
        }

        return result;

//        int lagestSum = Integer.MIN_VALUE;
//        int currSum = 0;
//        for(int i = 0 ;  i < nums.length;  i++){
//            currSum += nums[i];
//            if(lagestSum + currSum>  lagestSum){
//                lagestSum +=  currSum;
//            }
//        }
//        return lagestSum;

    }
}
