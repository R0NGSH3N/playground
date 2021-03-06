package com.justynsoft.da.integer;

public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args){
       int[] nums  = new int[]{0};
       //int[] nums  = new int[]{0,0,1,1,1,2,2,3,3,4};
       System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0 ){
            return 0;
        }
        int slowPointer = 0;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] != nums[slowPointer]){
                slowPointer = slowPointer + 1;
                nums[slowPointer] = nums[i];
            }
        }

        return slowPointer + 1;
    }
}
