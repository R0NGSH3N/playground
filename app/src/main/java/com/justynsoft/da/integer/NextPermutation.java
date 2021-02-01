package com.justynsoft.da.integer;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int[] result = insertArray(arr, 2, arr[arr.length - 1]);
        //System.out.println(Arrays.toString(result));
        int[] test = new int[]{1,5,1};
        nextPermutation(test);
        System.out.println(Arrays.toString(test));


    }
    public static void nextPermutation(int[] nums){
       //step 1, from right to left, find first decreasing numser
        int firstDescreasPos = -1;
        for(int i = nums.length -1; i > 0; i-- ){
            if(nums[i -1]  < nums[i]){
                firstDescreasPos = i - 1;
                break;
            }
        }

        //if can't find first decreasing number, just sort the array
        if(firstDescreasPos == -1){
            Arrays.sort(nums);
            return;
        }

        //step 2, from left to right, find least greater number of first Decrease number
        //because it is decreasing sequnce, so first element that less than nums[firstDescreasePos] found -1 is the least greater number
        int counter = firstDescreasPos + 1;
        while( counter < nums.length  && nums[firstDescreasPos] < nums[counter]){
            counter++;
        }
        counter = counter - 1;

        //step 3, swap 2 values
        int temp = nums[counter];
        nums[counter] = nums[firstDescreasPos];
        nums[firstDescreasPos] = temp;

        //step 4 reverse all the element after first decrease item
        int startPos = firstDescreasPos + 1;
        int endPos = nums.length -1;
        while(startPos <endPos ){
            int temp2 = nums[startPos];
            nums[startPos] = nums[endPos];
            nums[endPos] = temp2;
            startPos ++;
            endPos--;
        }
    }

    public static void nextPermutationOLd(int[] nums) {
        int count = nums.length - 1;
        int[] newArray = new int[nums.length];
        boolean found = false;

        outer : while(count > 0){
            for(int i = 1; i <= count ; i ++){
                if(nums[ count] > nums[count - i]) {
                    int minDiff = 0;
                    int minPos = -1;
                    for(int j = count ; j < nums.length; j++){
                        if(nums[j] > nums[count - 1] ){
                            minDiff = nums[count -1] - nums[j];
                            minPos = j;
                        }
                    }
                    if(minPos == -1){
                       minPos = nums.length -1;
                    }
                    int temp = nums[count - 1];
                    nums[count - i] = nums[ minPos];
                    nums[minPos] = temp;
                    found = true;
                    break outer;
                }
            }
            count = count - 1;

        }

        if(!found){
            Arrays.sort(nums);
        }
    }

    public static int[] deleteArray(int[] nums, int index){
        for(int i =  index; i < nums.length -1; i ++){
            nums[i] = nums[i + 1];
        }
        return nums;
    }

    public static int[] insertArray(int[] nums, int index, int value){
        int prevValue = nums[index];
        nums[index] = value;
        for(int i = index + 1; i < nums.length ; i++ ){
            int temp = nums[i];
            nums[i] = prevValue;
            prevValue = temp;

        }
        return nums;
    }
}
