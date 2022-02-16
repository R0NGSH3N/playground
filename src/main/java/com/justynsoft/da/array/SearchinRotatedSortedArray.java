package com.justynsoft.da.array;

public class SearchinRotatedSortedArray {
    public static void main(String[] args){
        int[] arr = new int[]{4,5,6,7,0,1,2};
        //System.out.println(search(arr, 0));
        System.out.println(search(new int[]{5,1,3}, 3));

    }

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int startPos = 0;
        int endPos = nums.length - 1;

        while(startPos +  1 <  endPos){
            int midPos = startPos + (endPos - startPos) /2;

            if(nums[midPos] == target){
                return midPos;
            }else{
                if( nums[startPos] < nums[endPos]){
                    if(target > nums[midPos]){
                        startPos = midPos;
                    }else{
                        endPos = midPos;
                    }
                }else {
                    if( nums[midPos] > nums[endPos]){
                        if(target > nums[midPos]){
                            startPos = midPos;
                        }else {
                            if(target >= nums[startPos]){
                               endPos = midPos;
                            }else{
                                startPos = midPos;
                            }
                        }
                    }else{
                        if(target < nums[midPos]){
                            endPos = midPos;
                        }else{
                            if(target > nums[endPos]){
                                endPos = midPos;
                            }else{
                                startPos = midPos;
                            }
                        }
                    }
                }
            }
        }

        if(nums[startPos] == target){
            return startPos;
        }

        if(nums[endPos] == target){
            return endPos;
        }

        return -1;
    }
}
