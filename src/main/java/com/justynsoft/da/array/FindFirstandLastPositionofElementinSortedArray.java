package com.justynsoft.da.array;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};
        System.out.println(searchRange(arr, 8));
        //System.out.println(searchRange(arr, 6));
        System.out.println(searchRange(new int[]{1,4}, 4));

    }
    public static int[] searchRange(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int startPos = 0;
        int endPos = nums.length - 1;

        int backwardPos = -1;
        int forwardPos = -1;

        while(startPos + 1 < endPos){
            int midPos = startPos + (endPos - startPos) / 2;
            if(nums[midPos] == target){
                backwardPos = midPos ;
                forwardPos = midPos ;

                while(backwardPos >= 0 && nums[backwardPos] == target){
                    backwardPos--;
                }

                while(forwardPos < nums.length && nums[forwardPos] == target){
                    forwardPos ++;
                }

                backwardPos += 1;
                forwardPos -= 1;
                break;

            }else if(nums[midPos] > target){
                endPos = midPos;
            }else{
                startPos = midPos;
            }
        }

        if(backwardPos == -1){
            if(nums[startPos] == target){
                backwardPos = startPos;
                forwardPos = startPos;
            }

            if(nums[endPos] == target){
                forwardPos = endPos;
                if(backwardPos == -1){
                    backwardPos = forwardPos;
                }
            }
        }

        return new int[]{backwardPos,forwardPos};
    }

    public static int[] searchRangeOLD(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int startPos = 0;
        int endPos = nums.length - 1;

        int[] result = new int[2];
        int backPos = -1;
        int forwardPos = -1;

        while (startPos  +1 < endPos) {
            int midPos = startPos + (endPos - startPos )/2;
            if (nums[midPos] == target) {
                int forwardSearch = midPos ;
                int backwardSearch = midPos ;
                while (backPos == -1 || forwardPos == -1) {
                    if (backwardSearch >=0 && backPos == -1) {
                        if (nums[backwardSearch] != target) {
                            backPos = backwardSearch + 1;
                        } else {
                            backwardSearch--;
                        }
                    }
                    if (forwardSearch < nums.length && forwardPos == -1) {
                        if (nums[forwardSearch] != target) {
                            forwardPos = forwardSearch -1;
                        } else {
                            forwardSearch++;
                        }
                    }
                }
                break;
            } else if (nums[midPos] > target) {
                endPos = midPos;
            } else {
                startPos = midPos;
            }
        }

        if(nums[startPos] == target ){
            backPos = startPos;
        }
        if(nums[endPos] == target){
            forwardPos = endPos;
        }


        result[0] = backPos;
        result[1] = forwardPos;
        return result;

    }

}
