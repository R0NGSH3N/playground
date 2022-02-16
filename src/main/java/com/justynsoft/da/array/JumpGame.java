package com.justynsoft.da.array;

public class JumpGame {
    public static void main(String[] args){
        int[] canJumpArr = {2,3,1,1,4};
        System.out.println(canJump(canJumpArr));
        int[] cannotJumpArr = {3,2,1,0,4};
        System.out.println(canJump(cannotJumpArr));
        int[] borderCase1 = {4};
        System.out.println(canJump(borderCase1));
        int[] borderCase2 = {0,4};
        System.out.println(canJump(borderCase2));
    }

    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return true;
        }
        int currentPosition = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int distToEnd = (nums.length - 1) - i;
            int currentValue = nums[i];

            //if current position number is able to jump to last position, we use current position
            if (currentValue >= distToEnd) {
                currentPosition = i;
            } else {
                //if current position number is NOT able to jump to end, then we check
                //if from current position number is able to jump last successful position? if yes, we replace it
                int distToLastPosition = currentPosition - i;
                if (distToLastPosition > 0 && currentValue >= distToLastPosition) {
                    currentPosition = i;
                }
            }
        }

        if (currentPosition == 0) {
            return true;
        } else {
            return false;
        }

    }
}
