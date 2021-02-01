package com.justynsoft.da.integer;

public class RemoveElement {

    public static void main(String[] args){
       int[] arr = new int[]{3,2,4,3} ;
       System.out.println(removeElement(arr,3));
    }


    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int slowPointer = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] != val){
                nums[slowPointer] = nums[i];
                slowPointer = slowPointer + 1;
            }
        }

        return slowPointer ;

    }
}
