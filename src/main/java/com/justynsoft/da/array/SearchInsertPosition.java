package com.justynsoft.da.array;

public class SearchInsertPosition {
    public static void main(String[] args){
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        // write your code here
        int startPos = 0;
        int endPos = nums.length - 1;

        if(nums[0] == target){
            return 0;
        }else if(nums[nums.length -1 ] == target){
            return nums.length - 1;
        }else if(nums[nums.length -1 ] <  target){
            return nums.length;
        }else if(nums[0] > target){
            return 0;
        }

        while(startPos +  1 < endPos) {
            int midPos = startPos + (endPos - startPos) / 2;
            if(nums[midPos] == target){
                return midPos;
            }else if(nums[midPos] > target){
                endPos = midPos;
            }else {
                startPos = midPos;
            }
        }

        if(nums[startPos] < target){
            return startPos + 1;
        }else{
            return startPos - 1;
        }

    }
}
